package de.bimalo.migration.application;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum Abteilung {
  FUSSBALL("Fußball", "Fußball-Abteilung", true),
  BREITENSPORT("Breitensport aktiv", "Breitensport-Abteilung", true),
  CRICKET("Cricket", "Cricket-Abteilung", true),
  FGL("FGL", "Faschingsgesellschaft", true),
  HANDBALL("Handball", "Handball-Abteilung", true),
  KARATE("Karate", "Hapkido-Karate-Abteilung", true),
  JUDO("Judo", "Judo-Abteilung", true),
  KEGELN("Kegeln", "Kegel-Abteilung", true),
  SCHACH("Schach", "Schach-Abteilung", true),
  TENNIS("Tennis", "Tennis-Abteilung", true),
  TISCHTENNIS("Tischtennis", "Tischtennis-Abteilung", true),
  VOLLEYBALL("Volleyball", "Volleyball-Abteilung", true);

  private String elvisAbteilung;
  private String kurabuAbteilung;
  private boolean migrate;

  public static Optional<Abteilung> findAbteilungByElvis(@NonNull String elvisAbteilung) {
    for (Abteilung c : values()) {
      if (c.elvisAbteilung.equals(elvisAbteilung.strip())) {
        return Optional.of(c);
      }
    }
    return Optional.empty();
  }

  public boolean mustBeMigrated() {
    return migrate;
  }
}
