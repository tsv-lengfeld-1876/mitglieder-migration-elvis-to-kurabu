package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Ehrung {
  TSV_LEISTUNGSNADEL_GOLD("ELG", "Leistungsnadel Gold", "TSV-Leistungsnadel Gold", true),
  TSV_LEISTUNGSNADEL_SILBER("ELS", "Leistungsnadel Silber", "TSV-Leistungsnadel Silber", true),
  TSV_LEISTUNGSNADEL_BRONZE("ELB", "Leistungsnadel Bronze", "TSV-Leistungsnadel Bronze", true),
  TSV_LEISTUNGSNADEL_GOLD_BRILLIANT(
      "EBr", "Leistungsnadel Gold Brilliant", "TSV-Leistungsnadel Gold Brilliant", true),
  TSV_SONDEREHRUNG("ESO", "Sonderehrungen", "TSV-Sonderehrungen", true),
  TSV_VEREINSNADEL_GOLD("E40", "Vereinsnadel Gold 40 Jahre", "TSV-Vereinsnadel Gold", true),
  TSV_VEREINSNADEL_GOLD_50("E50", "Vereinsnadel Gold 50 Jahre", "TSV-Vereinsnadel Gold", true),
  TSV_VEREINSNADEL_SILBER("E25", "Vereinsnadel Silber", "TSV-Vereinsnadel Silber", true),
  TSV_VEREINSNADEL_BRONZE("E15", "Vereinsnadel Bronze", "TSV-Vereinsnadel Bronze", true);

  @Getter private String elvisEhrungKennung;
  @Getter private String elvisEhrung;
  @Getter private String kurabuEhrung;
  private boolean migrate;

  public static Ehrung findEhrungByElvis(String elvisEhrungKennung) {
    for (Ehrung e : values()) {
      if (e.elvisEhrungKennung.equals(elvisEhrungKennung)) {
        return e;
      }
    }
    throw new IllegalArgumentException(
        String.format("Ehrung %s aus Elvis nicht bekannt.", elvisEhrungKennung));
  }

  public boolean mustBeMigrated() {
    return migrate;
  }
}
