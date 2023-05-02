package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.Mitglieder;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.java.Log;

@Log
public final class AbteilungenAnalyzer {

  public void analyze(Mitglieder mitglieder) {
    Set<String> abteilungen = new HashSet<>();

    mitglieder.getMitglied().stream()
        .forEach(
            m ->
                m.getAbteilungen().getAbteilung().stream()
                    .forEach(a -> abteilungen.add(a.getBezeichnung())));

    abteilungen.stream().forEach(a -> log.info(a));
  }
}
