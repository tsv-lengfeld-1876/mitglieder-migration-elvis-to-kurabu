package de.bimalo.migration.application;

import de.bimalo.migration.entity.Abteilungszuordnung;
import de.bimalo.migration.entity.MappingResult;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import io.quarkus.runtime.util.StringUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.extern.java.Log;

@Log
public final class AbteilungszuordnungBuilder {

  private DateTimeFormatter dateFormatter;

  public AbteilungszuordnungBuilder() {
    dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
  }

  public List<Abteilungszuordnung> build(
      @NonNull List<MappingResult<Mitglieder.Mitglied, KurabuMitglied>> mappingResults) {

    List<Abteilungszuordnung> abteilungszuordnungen =
        mappingResults.stream()
            .filter(f -> !f.failed())
            .flatMap(m -> buildAbteilungsZuordnungen(m).stream())
            .collect(Collectors.toList());

    return abteilungszuordnungen;
  }

  private List<Abteilungszuordnung> buildAbteilungsZuordnungen(
      MappingResult<Mitglieder.Mitglied, KurabuMitglied> mappingResult) {
    List<Abteilungszuordnung> abteilungsZuordnungen = new ArrayList<>();

    Mitglieder.Mitglied elvisMitglied = mappingResult.getSource();

    elvisMitglied.getAbteilungen().getAbteilung().stream()
        .filter(f -> inAbteilungNochAktiv(f) && !isAbteilungNichtMehrBenoetigt(f))
        .forEach(
            a -> {
              Optional<Abteilung> kurabuAbteilung =
                  Abteilung.findAbteilungByElvis(a.getBezeichnung());
              if (kurabuAbteilung.isPresent()) {
                Abteilungszuordnung zuordnung = new Abteilungszuordnung();
                zuordnung.setMitgliedsNr(elvisMitglied.getNummer());
                zuordnung.setVorname(elvisMitglied.getPersonalien().getVorname());
                zuordnung.setNachname(elvisMitglied.getPersonalien().getNachname());
                zuordnung.setAbteilungen(kurabuAbteilung.get().getKurabuAbteilung());
                zuordnung.setEintritt(LocalDate.parse(a.getEintrittsdatum(), dateFormatter));
                if (!abteilungsZuordnungen.contains(zuordnung)) {
                  abteilungsZuordnungen.add(zuordnung);
                }
              } else {
                log.info(
                    "Konnte keine Abteilung in Kurabu für "
                        + a.getBezeichnung()
                        + " aus Elvis finden.");
              }
            });

    return abteilungsZuordnungen;
  }

  private Abteilungszuordnung buildAbteilungsZuordnung(
      MappingResult<Mitglieder.Mitglied, KurabuMitglied> mappingResult) {
    Abteilungszuordnung zuordnung = new Abteilungszuordnung();
    zuordnung.setMitgliedsNr(mappingResult.getSource().getNummer());
    zuordnung.setVorname(mappingResult.getSource().getPersonalien().getVorname());
    zuordnung.setNachname(mappingResult.getSource().getPersonalien().getNachname());
    zuordnung.setAbteilungen("\"" + determineAbteilungen(mappingResult.getSource()) + "\"");

    return zuordnung;
  }

  private String determineAbteilungen(Mitglieder.Mitglied elvisMitglied) {
    StringJoiner abtlJoiner = new StringJoiner(";");

    for (Mitglieder.Mitglied.Abteilungen.Abteilung elvisAbteilung :
        elvisMitglied.getAbteilungen().getAbteilung()) {
      Optional<Abteilung> neueAbteilung =
          Abteilung.findAbteilungByElvis(elvisAbteilung.getBezeichnung());
      if (neueAbteilung.isPresent()) {
        abtlJoiner.add(neueAbteilung.get().getKurabuAbteilung());
      }
    }

    return abtlJoiner.toString();
  }

  private boolean inAbteilungNochAktiv(Mitglieder.Mitglied.Abteilungen.Abteilung elvisAbteilung) {
    return StringUtil.isNullOrEmpty(elvisAbteilung.getAustrittsdatum());
  }

  private boolean isAbteilungNichtMehrBenoetigt(
      Mitglieder.Mitglied.Abteilungen.Abteilung elvisAbteilung) {
    return elvisAbteilung.getBezeichnung().equals("TSV Lengfeld 1876 e.V.")
        || elvisAbteilung.getBezeichnung().equals("Sonstige Mitglieder")
        || elvisAbteilung.getBezeichnung().equals("Tanzsport");
  }
}
