package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.Mitglieder;
import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Set;

@Log
public final class AbteilungenAnalyzer {

    public void analyze(Mitglieder mitglieder) {
        Set<String> abteilungen = new HashSet<>();

        mitglieder.getMitglied().stream().forEach(m -> m.getAbteilungen().getAbteilung().stream().forEach(a->abteilungen.add(a.getBezeichnung())));

        abteilungen.stream().forEach(a -> log.info(a));
    }
}
