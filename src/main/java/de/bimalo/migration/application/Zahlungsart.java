package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Zahlungsart {
  BARZAHLER("Barzahler", "Banküberweisung"),
  LASTSCHRIFTENZAHLER("Lastschriftenzahler", "SEPA"),
  RECHNUNGSZAHLER("Rechnungszahler", "Banküberweisung");

  private String elvisZahlungsart;
  private String kurabuZahlungsart;

  public static Zahlungsart findZahlungsart(String elvisZahlungsart) {
    for (Zahlungsart a : values()) {
      if (a.elvisZahlungsart.equals(elvisZahlungsart)) {
        return a;
      }
    }
    throw new IllegalArgumentException(
        String.format("Zahlungsart %s aus Elvis nicht bekannt.", elvisZahlungsart));
  }
}
