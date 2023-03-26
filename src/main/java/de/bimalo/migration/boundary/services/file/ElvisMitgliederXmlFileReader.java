package de.bimalo.migration.boundary.services.file;

import de.bimalo.migration.application.KurabuImportFileCreatorRoute;
import de.bimalo.migration.application.MitgliederMigrationRoute;
import de.bimalo.migration.application.ReportFileCreatorRoute;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public final class ElvisMitgliederXmlFileReader extends RouteBuilder {

  public static final String ROUTE_ID = ElvisMitgliederXmlFileReader.class.getName();
  public static final String ROUTE_URL = "direct:" + ROUTE_ID;

  // spotless:off
  @Override
  public void configure() throws Exception {
    getCamelContext().setUseMDCLogging(true);
    getCamelContext().setUseBreadcrumb(true);

    from("file:src/test/resources/?fileName=Export-XML-Mitglieder-Alle.xml&charset=UTF-8")
        .routeId(ROUTE_ID)
        .setHeader(Exchange.BREADCRUMB_ID, simple("date:now:YYYYMMddHH:mm:ss"))
        .log(
            LoggingLevel.INFO,
            "============ BEGIN: docnum=${header.breadcrumbId} file=${file:name} ============ ")
        .to(MitgliederMigrationRoute.ROUTE_URL)
        .multicast()
        .to(KurabuImportFileCreatorRoute.ROUTE_URL)
        .to(ReportFileCreatorRoute.ROUTE_URL)
        .log(
            LoggingLevel.INFO,
            "============ FINISHED: docnum=${header.breadcrumbId} file=${file:name} ============ ");
  }
  // spotless:on
}
