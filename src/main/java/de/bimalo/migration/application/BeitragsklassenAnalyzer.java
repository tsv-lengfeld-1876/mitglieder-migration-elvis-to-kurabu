package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.Mitglieder;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.java.Log;

@Log
public final class BeitragsklassenAnalyzer {

  public void analyze(Mitglieder mitglieder) {
    Set<String> beitragsarten = new HashSet<>();

    mitglieder.getMitglied().stream()
        .forEach(
            m ->
                m.getBeitraege().getBeitrag().stream()
                    .forEach(b -> beitragsarten.add(b.getBeitragsart())));

    beitragsarten.stream().forEach(beitragsart -> log.info(beitragsart));
  }
}
