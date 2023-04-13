package de.bimalo.migration.entity.kurabu;

import io.quarkus.runtime.util.StringUtil;
import java.time.LocalDate;
import java.util.StringJoiner;
import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ";", generateHeaderColumns = true, quoting = true, quotingEscaped = true)
@Data
public final class KurabuMitglied {

  @DataField(pos = 1, columnName = "Titel")
  private String titel;

  @DataField(pos = 2, columnName = "Vorname", required = true)
  private String vorname;

  @DataField(pos = 3, required = true, columnName = "Nachname")
  private String nachname;

  @DataField(pos = 4, required = true, columnName = "Profil-ID")
  private String profilId;

  @DataField(pos = 5, required = true, pattern = "dd.MM.yyyy", columnName = "Mitglied seit")
  private LocalDate mitgliedSeit;

  @DataField(pos = 6, pattern = "dd.MM.yyyy", columnName = "Mitglied bis")
  private LocalDate mitgliedBis;

  @DataField(pos = 7, required = true, columnName = "Beiträge")
  private String beitraege;

  @DataField(pos = 8, columnName = "Email")
  private String email;

  @DataField(pos = 9, columnName = "Telefon")
  private String telefon;

  @DataField(pos = 10, required = true, pattern = "dd.MM.yyyy", columnName = "Geburtsdatum")
  private LocalDate geburtsdatum;

  @DataField(pos = 11, required = true, columnName = "Geschlecht")
  private String geschlecht;

  @DataField(pos = 12, required = true, columnName = "Straße")
  private String strasse;

  @DataField(pos = 13, columnName = "Adresszeile 2")
  private String adresszeile2;

  @DataField(pos = 14, required = true, columnName = "PLZ")
  private Integer plz;

  @DataField(pos = 15, required = true, columnName = "Stadt")
  private String stadt;

  @DataField(pos = 16, columnName = "Land")
  private String Land;

  @DataField(pos = 17, columnName = "Familie / Gruppe")
  private String familienGruppe;

  @DataField(pos = 18, columnName = "Zahlungsmethode")
  private String zahlungsmethode;

  @DataField(pos = 19, columnName = "Kontoinhaber")
  private String kontoinhaber;

  @DataField(pos = 20, columnName = "IBAN")
  private String iban;

  @DataField(pos = 21, columnName = "SEPA-Mandats-ID")
  private String sepaMandatsId;

  @DataField(pos = 22, pattern = "dd.MM.yyyy", columnName = "Datum der Mandatsunterschrift")
  private LocalDate datumMandatsunterschrift;

  @DataField(pos = 23, columnName = "Saldo")
  private String saldo;

  @DataField(pos = 24, columnName = "Teamleiter(in)")
  private boolean teamleiter = false;

  @DataField(pos = 25, columnName = "Notizen")
  private String notizen;

  @DataField(pos = 26, columnName = "Mobil")
  private String mobil;

  @DataField(pos = 27, columnName = "Telefon2")
  private String telefon2;

  @DataField(pos = 28, pattern = "dd.MM.yyyy", columnName = "Kündigungsdatum")
  private LocalDate kuendigungsDatum;

  @DataField(pos = 29, columnName = "Kündigungsgrund")
  private String kuendigungsGrund;

  @DataField(pos = 30, columnName = "Ehrenmitglied")
  private boolean ehrenmitglied;

  @DataField(pos = 31, columnName = "Funktionen")
  private String funktionen;

  @DataField(pos = 32, columnName = "Ehrungen")
  private String ehrungen;

  @DataField(pos = 33, columnName = "Nationalität")
  private String nationalitaet;

  @DataField(pos = 34, columnName = "Integrationshintergrund")
  private boolean integrationshintergrund = false;

  @DataField(pos = 35, columnName = "TSV-aktuell in Papierform")
  private boolean tsvaktuellAlsPapier = false;

  @DataField(pos = 36, columnName = "Führungszeugnis vorgelegt")
  private boolean fuehrungszeugnisVorgelegt = false;

  @DataField(pos = 37, columnName = "Übungsleiterlizenz")
  private String uebungsleiterlizenz;

  @DataField(pos = 38, pattern = "dd.MM.yyyy", columnName = "Übungsleiterlizenz gültig bis")
  private LocalDate uebungsleiterlizenzGueltigBis;

  @DataField(pos = 39, columnName = "verstorben")
  private boolean verstorben = false;

  @DataField(pos = 40, columnName = "ALG-Bezieher")
  private boolean algBezieher = false;

  @DataField(pos = 41, columnName = "Senioreneinladung")
  private boolean senioreneinladung = false;

  public boolean addEhrung(String ehrung) {
    if (!StringUtil.isNullOrEmpty(ehrung)) {
      StringJoiner ehrungenJoiner = new StringJoiner(";");
      if (!StringUtil.isNullOrEmpty(ehrungen)) {
        ehrungenJoiner.add(ehrungen);
      }
      ehrungenJoiner.add(ehrung);
      ehrungen = ehrungenJoiner.toString();
      return true;
    } else {
      return false;
    }
  }

  public boolean addNotiz(String notiz) {
    if (!StringUtil.isNullOrEmpty(notiz)) {
      StringJoiner notizenJoiner = new StringJoiner("\n");
      if (!StringUtil.isNullOrEmpty(notizen)) {
        notizenJoiner.add(notizen);
      }
      notizenJoiner.add(notiz);
      notizen = notizenJoiner.toString();
      return true;
    } else {
      return false;
    }
  }

  public boolean addBeitrag(String beitrag) {
    if (!StringUtil.isNullOrEmpty(beitrag)) {
      StringJoiner beitragsJoiner = new StringJoiner(";");
      if (!StringUtil.isNullOrEmpty(beitraege)) {
        beitragsJoiner.add(beitraege);
      }
      beitragsJoiner.add(beitrag);
      beitraege = beitragsJoiner.toString();
      return true;
    } else {
      return false;
    }
  }
}
