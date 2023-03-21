package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.ElvisMitgliedWithIban;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import lombok.NonNull;
import lombok.extern.java.Log;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.iban4j.IbanFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Log
public final class ElvisToKurabuMitgliederMapper {

    private DateTimeFormatter dateFormatter;
    private List<ElvisMitgliedWithIban> elvisMitgliederIbanListe;

    public ElvisToKurabuMitgliederMapper() {
        dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        elvisMitgliederIbanListe = new ArrayList<>();
    }

    public ElvisToKurabuMitgliederMapper(@NonNull List<ElvisMitgliedWithIban> elvisMitgliederIbanListe) {
        dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        this.elvisMitgliederIbanListe = elvisMitgliederIbanListe;
    }

    public void setElvisMitgliederIbanListe(@NonNull List<ElvisMitgliedWithIban> elvisMitgliederIbanListe) {
        this.elvisMitgliederIbanListe = elvisMitgliederIbanListe;
    }

    public List<KurabuMitglied> map(@NonNull Mitglieder elvisMitglieder) {

        List<KurabuMitglied> kurabuMitglieder = elvisMitglieder.getMitglied().stream().map(em -> mapMitglied(em)).collect(Collectors.toList());
        return kurabuMitglieder;
    }


    private KurabuMitglied mapMitglied(Mitglieder.Mitglied elvisMitglied) {
        KurabuMitglied kurabuMitglied = new KurabuMitglied();

        try {
            mapPersonalien(elvisMitglied, kurabuMitglied);
            mapAdresse(elvisMitglied, kurabuMitglied);
            mapKommunikation(elvisMitglied, kurabuMitglied);
            mapMitgliederStatus(elvisMitglied, kurabuMitglied);
            mapZahlungsdaten(elvisMitglied, kurabuMitglied);
            mapAbteilungToNotizen(elvisMitglied, kurabuMitglied);
            mapBeitraege(elvisMitglied, kurabuMitglied);
            mapFamilie(elvisMitglied, kurabuMitglied);
            mapEhrungen(elvisMitglied, kurabuMitglied);
            mapCustomFields(elvisMitglied, kurabuMitglied);
        }
        catch (Exception ex) {
            //throw new RuntimeException(String.format("Could not migrate %s %s (%s), because of %s.", elvisMitglied.getPersonalien().getVorname(), elvisMitglied.getPersonalien().getNachname(), elvisMitglied.getNummer(), ex.getMessage()), ex);
            log.info(String.format("Could not migrate %s %s (%s), because of %s.", elvisMitglied.getPersonalien().getVorname(), elvisMitglied.getPersonalien().getNachname(), elvisMitglied.getNummer(), ex.getMessage()));
   
        }
        return kurabuMitglied;
    }

    private void mapPersonalien(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        kurabuMitglied.setTitel(elvisMitglied.getPersonalien().getTitel());
        kurabuMitglied.setVorname(elvisMitglied.getPersonalien().getVorname());
        kurabuMitglied.setNachname(elvisMitglied.getPersonalien().getNachname());
        kurabuMitglied.setProfilId(elvisMitglied.getNummer());
        kurabuMitglied.setGeburtsdatum(LocalDate.parse(elvisMitglied.getPersonalien().getGeburtsdatum(), dateFormatter));
        kurabuMitglied.setGeschlecht(Geschlecht.findGeschlechtByElvis(elvisMitglied.getPersonalien().getGeschlecht()).getKurabuGeschlecht());
    }

    private void mapAdresse(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
          kurabuMitglied.setStrasse(compineStrasseUndHausnummer(elvisMitglied));
          kurabuMitglied.setPlz(elvisMitglied.getAdresse().getPostleitzahl());
          kurabuMitglied.setStadt(elvisMitglied.getAdresse().getOrt());
          if (isValidValue(elvisMitglied.getAdresse().getLandeskennung())) {
              kurabuMitglied.setLand(elvisMitglied.getAdresse().getLandeskennung());
          }
          else {
              kurabuMitglied.setLand("Deutschland");
          }
    }

    private void mapMitgliederStatus(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        kurabuMitglied.setMitgliedSeit(LocalDate.parse(elvisMitglied.getStatus().getEintrittsdatum(), dateFormatter));
        if (isValidValue(elvisMitglied.getStatus().getKuendigungsdatum())) {
            kurabuMitglied.setMitgliedBis(LocalDate.parse(elvisMitglied.getStatus().getAustrittsdatum(), dateFormatter));
            kurabuMitglied.setKuendigungsDatum(LocalDate.parse(elvisMitglied.getStatus().getKuendigungsdatum(), dateFormatter));
            kurabuMitglied.setKuendigungsGrund(elvisMitglied.getStatus().getKuendigungsgrund());
        }

    }

    private void mapKommunikation(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        kurabuMitglied.setTelefon(elvisMitglied.getKommunikation().getPrivat().getTelefon());
        kurabuMitglied.setEmail(elvisMitglied.getKommunikation().getPrivat().getEmail());
        kurabuMitglied.setMobil(elvisMitglied.getKommunikation().getPrivat().getMobil());
        if (isValidValue(elvisMitglied.getKommunikation().getDienstlich().getTelefon())) {
            kurabuMitglied.setTelefon2(elvisMitglied.getKommunikation().getDienstlich().getTelefon());
        }
        else if (isValidValue(elvisMitglied.getKommunikation().getDienstlich().getMobil())) {
            kurabuMitglied.setTelefon2(elvisMitglied.getKommunikation().getDienstlich().getMobil());
        }
    }

    private void mapZahlungsdaten(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        if (isSelbstzahler(elvisMitglied)) {
            Zahlungsart zahlungsArt = Zahlungsart.findZahlungsart(elvisMitglied.getZahlungsdaten().getZahlungsart());
            kurabuMitglied.setZahlungsmethode(zahlungsArt.getKurabuZahlungsart());
            if (zahlungsArt == Zahlungsart.LASTSCHRIFTENZAHLER) {
                kurabuMitglied.setKontoinhaber(compineStringValues(elvisMitglied.getZahlungsdaten().getZahlervorname(), elvisMitglied.getZahlungsdaten().getZahlernachname()));
                kurabuMitglied.setSepaMandatsId(elvisMitglied.getNummer());
                kurabuMitglied.setIban(calculateIban(elvisMitglied).toFormattedString());
                kurabuMitglied.setDatumMandatsunterschrift(LocalDate.parse(elvisMitglied.getStatus().getEintrittsdatum(), dateFormatter));
            }
            else if (zahlungsArt == Zahlungsart.RECHNUNGSZAHLER) {
                kurabuMitglied.setSaldo(elvisMitglied.getZahlungsdaten().getKontosaldo());
            }
        }
    }

    private void mapAbteilungToNotizen(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
            StringJoiner notizenJoiner = new StringJoiner("\n");

            for (Mitglieder.Mitglied.Abteilungen.Abteilung elvisAbteilung : elvisMitglied.getAbteilungen().getAbteilung()) {
                notizenJoiner.add(String.format("Abteilung %s (%s): Eintritt= %s - Austritt= %s.", elvisAbteilung.getBezeichnung(), elvisAbteilung.getAktivPassiv(), elvisAbteilung.getEintrittsdatum(), elvisAbteilung.getAustrittsdatum()));
            }

            notizenJoiner.add("");
            kurabuMitglied.setNotizen("\"" + notizenJoiner.toString() + "\"");
      }

   private void mapBeitraege(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
       StringJoiner beitragsJoiner = new StringJoiner(";");

       for(Mitglieder.Mitglied.Beitraege.Beitrag elvisBeitrag : elvisMitglied.getBeitraege().getBeitrag()) {
           Beitragsklasse beitragsKlasse = Beitragsklasse.findBeitragsklasseByElvis(elvisBeitrag.getBeitragsart().strip());
           if (beitragsKlasse.mustBeMigrated()) {
               beitragsJoiner.add(beitragsKlasse.getKurabuBeitrag());
           }
       }
       kurabuMitglied.setBeitraege("\"" + beitragsJoiner.toString() + "\"");
   }

    private void mapEhrungen(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        //TODO
    }

    private void mapFamilie(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
        //TODO
    }

    private void mapCustomFields(Mitglieder.Mitglied elvisMitglied, KurabuMitglied kurabuMitglied) {
      //TODO
    }

    private boolean isSelbstzahler(Mitglieder.Mitglied elvisMitglied) {
        return elvisMitglied.getZahlerdaten() == null && elvisMitglied.getZahlungsdaten() != null;
    }
    private Iban calculateIban(Mitglieder.Mitglied elvisMitglied) {
        String ibanv = findIbanByMitgliedsNr(elvisMitglied.getNummer());
        if (!isValidValue(ibanv)) {
            String kontonummer = padLeftZeros(elvisMitglied.getZahlungsdaten().getBankverbindung().getKontonummer(), 10);
            String blz = elvisMitglied.getZahlungsdaten().getBankverbindung().getBankleitzahl();
            String bankName = elvisMitglied.getZahlungsdaten().getBankverbindung().getBankname();
            if (!isValidValue(blz)) {
                Bank bank = Bank.findBank(bankName);
                blz = bank.getBlz();
            }
            try {
                return new Iban.Builder().countryCode(CountryCode.DE).bankCode(blz.trim()).accountNumber(kontonummer.trim()).build();
            } catch (IbanFormatException ex) {
                log.info(String.format("Ktn-Nr.=%s, Blz= %s, Bank= %s", kontonummer, blz, bankName));
                throw ex;
            }
        }
        else {
            return Iban.valueOf(ibanv);
        }
    }

    private String compineStrasseUndHausnummer(Mitglieder.Mitglied elvisMitglied) {
        return String.format("%s %s", elvisMitglied.getAdresse().getStrasse().strip().trim(), elvisMitglied.getAdresse().getHausnummer().strip().trim());
    }

    private String compineStringValues(@NonNull String value1, @NonNull String value2) {
        return String.format("%s %s", value1, value2);
    }

    private boolean isValidValue(String value) {
        return value != null && !value.isEmpty() && !value.isBlank();
    }

    private String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    private String findIbanByMitgliedsNr(String mitgliedsNr) {
        ElvisMitgliedWithIban mitglied = elvisMitgliederIbanListe.stream().filter(m -> m.getMitgliedNr().equals(mitgliedsNr)).findAny().orElse(null);
        if (mitglied != null) {
            return mitglied.getIban();
        }
        else {
            return null;
        }
    }
}
