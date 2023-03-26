package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Abteilung {
  FUSSBALL("Fußball", "Fußball-Abteilung", true),
  BREITENSPORT("Fußball", "Breitensport-Abteilung", true),
  CRICKET("Fußball", "Cricket-Abteilung", true),
  FGL("Fußball", "Faschingsgesellschaft", true),
  HANDBALL("Fußball", "Handball-Abteilung", true),
  KARATE("Fußball", "Hapkido-Karate-Abteilung", true),
  JUDO("Fußball", "Judo-Abteilung", true),
  KEGELN("Fußball", "Kegel-Abteilung", true),
  SCHACH("Fußball", "SCHACH-Abteilung", true),
  TENNIS("Fußball", "TENNIS-Abteilung", true),
  TISCHTENNIS("Fußball", "Tischtennis-Abteilung", true),
  VOLLEYBALL("Fußball", "Volleyball-Abteilung", true);

  private String elvisAbteilung;
  private String kurabuAbteilung;
  private boolean migrate;

  public static Abteilung findAbteilungByElvis(String elvisAbteilung) {
    for (Abteilung c : values()) {
      if (c.elvisAbteilung.equals(elvisAbteilung)) {
        return c;
      }
    }
    throw new IllegalArgumentException(
        String.format("Abteilung %s aus Elvis nicht bekannt.", elvisAbteilung));
  }
}
