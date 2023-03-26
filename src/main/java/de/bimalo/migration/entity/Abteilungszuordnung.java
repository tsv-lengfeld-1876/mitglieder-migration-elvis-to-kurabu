package de.bimalo.migration.entity;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ";", generateHeaderColumns = true)
@Data
public final class Abteilungszuordnung {

  @DataField(pos = 1, columnName = "Mitglieds-Nr.", required = true)
  private String mitgliedsNr;

  @DataField(pos = 2, columnName = "Vorname", required = true)
  private String vorname;

  @DataField(pos = 3, required = true, columnName = "Nachname")
  private String nachname;

  @DataField(pos = 4, required = true, columnName = "Abteilungen")
  private String abteilungen;
}
