package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.Mitglieder;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;

@Log
public final class KommunikationAnalyzer {

  public void analyze(Mitglieder mitglieder) {
    List<Mitglieder.Mitglied> mitgliederMitDienstKommunikation = new ArrayList<>();

    mitglieder
        .getMitglied()
        .forEach(
            mitglied -> {
              if (dienstlicheKommunikationVorhanden(mitglied)) {
                mitgliederMitDienstKommunikation.add(mitglied);
              }
            });

    log.info("Mitglieder mit Kommunikation dienstlich: ");
    mitgliederMitDienstKommunikation.stream()
        .forEach(
            a ->
                log.info(
                    String.format(
                        "%s %s (%s)",
                        a.getPersonalien().getVorname(),
                        a.getPersonalien().getNachname(),
                        a.getNummer())));
  }

  private boolean dienstlicheKommunikationVorhanden(Mitglieder.Mitglied mitglied) {
    Mitglieder.Mitglied.Kommunikation.Dienstlich dienstlich =
        mitglied.getKommunikation().getDienstlich();
    return isValidValue(dienstlich.getEmail())
        || isValidValue(dienstlich.getFax())
        || isValidValue(dienstlich.getInternetadresse())
        || isValidValue(dienstlich.getMobil())
        || isValidValue(dienstlich.getPager())
        || isValidValue(dienstlich.getTelefon());
  }

  private boolean isValidValue(String value) {
    return value != null && !value.isEmpty() && !value.isBlank();
  }
}
