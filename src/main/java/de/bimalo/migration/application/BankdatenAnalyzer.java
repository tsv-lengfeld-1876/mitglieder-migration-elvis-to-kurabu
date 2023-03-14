package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.Mitglieder;
import lombok.extern.java.Log;

import java.util.HashSet;
import java.util.Set;

@Log
public final class BankdatenAnalyzer {

    public void analyze(Mitglieder mitglieder) {
        Set<String> banken = new HashSet<>();

        mitglieder.getMitglied().stream().forEach(m -> {
            if (m.getZahlungsdaten() != null && m.getZahlungsdaten().getBankverbindung().getBankleitzahl().isEmpty()) {
                banken.add(m.getZahlungsdaten().getBankverbindung().getBankname());
            }
        });

        banken.stream().forEach(a -> log.info(a));

    }
}
