package de.bimalo.migration.application;

import de.bimalo.migration.entity.MappingResult;
import de.bimalo.migration.entity.ReportEntry;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.extern.java.Log;

@Log
public final class ReportBuilder {

  public List<ReportEntry> build(
      @NonNull List<MappingResult<Mitglieder.Mitglied, KurabuMitglied>> mappingResults) {

    List<ReportEntry> report =
        mappingResults.stream().map(r -> buildReportEntry(r)).collect(Collectors.toList());
    return report;
  }

  private ReportEntry buildReportEntry(
      MappingResult<Mitglieder.Mitglied, KurabuMitglied> mappingResult) {
    ReportEntry report = new ReportEntry();
    report.setMitgliedsNr(mappingResult.getSource().getNummer());
    report.setVorname(mappingResult.getSource().getPersonalien().getVorname());
    report.setNachname(mappingResult.getSource().getPersonalien().getNachname());
    if (mappingResult.getException() != null) {
      report.setMessage("\"" + exceptionToString(mappingResult.getException()) + "\"");
    }
    report.setFailed(mappingResult.failed());

    return report;
  }

  private String exceptionToString(Exception ex) {
    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw));
    return sw.toString();
  }
}
