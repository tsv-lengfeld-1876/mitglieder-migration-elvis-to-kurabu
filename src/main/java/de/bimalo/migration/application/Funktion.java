package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Funktion {
  EHRENMITGLIED("F08", "Ehrenmitglied", "Ehrenmitglied", false),
  AUSGESCHIEDEN_SONSTIGE(
      "F07", "ausgeschiedene Abt.L./Verw,/sonst. Funktionen", "Ausgeschieden", false),
  AUSGESCHIEDEN_VORSTAND("F06", "ausgeschiedene Vorstandsmitglieder", "Ausgeschieden", false),
  SONSTIGE_FUNKTIONEN("F05", "sonst. Funktionen", "Sonstige Funktionen", false),
  VERWALTUNG("F03", "Verwaltung", "Verwaltung", true),
  VORSTANDSMITGLIED("F01", "Vorstandsmitglied", "Vorstand", true),
  UBUNGSLEITER("F04", "Übungsleiter", "Übungsleiter", true),
  ABTEILUNGSLEITER_1("F02", "1. Abteilungsleiter", "1. Abteilungsleiter", true),
  ABTEILUNGSLEITER_2("F09", "2. Abteilungsleiter", "2. Abteilungsleiter", true),
  ABTEILUNGSLEITER_3("F10", "3. Abteilungsleiter", "3. Abteilungsleiter", true);

  @Getter private String elvisFunktionKennung;
  @Getter private String elvisFunktion;
  @Getter private String kurabuFunktion;
  private boolean migrate;

  public static Funktion findFunktionByElvis(String elvisFunktionKennung) {
    for (Funktion f : values()) {
      if (f.elvisFunktionKennung.equals(elvisFunktionKennung)) {
        return f;
      }
    }
    throw new IllegalArgumentException(
        String.format("Funktion %s aus Elvis nicht bekannt.", elvisFunktionKennung));
  }

  public boolean mustBeMigrated() {
    return migrate;
  }
}
