package de.bimalo.migration.application;

import de.bimalo.migration.entity.Abteilungszuordnung;
import de.bimalo.migration.entity.MappingResult;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.extern.java.Log;

@Log
public final class AbteilungszuordnungBuilder {

  public List<Abteilungszuordnung> build(
      @NonNull List<MappingResult<Mitglieder.Mitglied, KurabuMitglied>> mappingResults) {

    List<Abteilungszuordnung> abteilungszuordnungen =
        mappingResults.stream()
            .filter(r -> !r.failed())
            .map(r -> buildAbteilungszuordnung(r))
            .collect(Collectors.toList());
    return abteilungszuordnungen;
  }

  private Abteilungszuordnung buildAbteilungszuordnung(
      MappingResult<Mitglieder.Mitglied, KurabuMitglied> mappingResult) {
    Abteilungszuordnung zuordnung = new Abteilungszuordnung();
    zuordnung.setMitgliedsNr(mappingResult.getSource().getNummer());
    zuordnung.setVorname(mappingResult.getSource().getPersonalien().getVorname());
    zuordnung.setNachname(mappingResult.getSource().getPersonalien().getNachname());
    zuordnung.setAbteilungen("\"" + determineAbteilungen(mappingResult.getSource()) + "\"");

    return zuordnung;
  }

  private String determineAbteilungen(Mitglieder.Mitglied elvisMitglied) {
    StringJoiner abtlJoiner = new StringJoiner(";");

    for (Mitglieder.Mitglied.Abteilungen.Abteilung elvisAbteilung :
        elvisMitglied.getAbteilungen().getAbteilung()) {
      Optional<Abteilung> neueAbteilung =
          Abteilung.findAbteilungByElvis(elvisAbteilung.getBezeichnung());
      if (neueAbteilung.isPresent()) {
        abtlJoiner.add(neueAbteilung.get().getKurabuAbteilung());
      }
    }

    return abtlJoiner.toString();
  }
}
