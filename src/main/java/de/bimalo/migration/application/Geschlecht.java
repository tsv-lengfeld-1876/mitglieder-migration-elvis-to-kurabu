package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Geschlecht {
  MAENNLICH("M", "Männlich"),
  WEIBLICH("W", "Weiblich");

  private String elvisGeschlecht;
  private String kurabuGeschlecht;

  public static Geschlecht findGeschlechtByElvis(String elvisGeschlecht) {
    for (Geschlecht c : values()) {
      if (c.elvisGeschlecht.equals(elvisGeschlecht)) {
        return c;
      }
    }
    throw new IllegalArgumentException(
        String.format("Geschlecht %s aus Elvis nicht bekannt.", elvisGeschlecht));
  }
}
