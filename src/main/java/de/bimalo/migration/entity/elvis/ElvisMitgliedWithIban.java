package de.bimalo.migration.entity.elvis;

import lombok.Data;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ";", skipFirstLine = true)
@Data
public class ElvisMitgliedWithIban {

    @DataField(pos = 1, columnName = "Mitglied-Nr")
    private String mitgliedNr;

    @DataField(pos = 2, columnName = "Nachname")
    private String nachname;

    @DataField(pos = 3, columnName = "Vorname")
    private String vorname;

    @DataField(pos = 4, columnName = "IBAN")
    private String iban;

}
