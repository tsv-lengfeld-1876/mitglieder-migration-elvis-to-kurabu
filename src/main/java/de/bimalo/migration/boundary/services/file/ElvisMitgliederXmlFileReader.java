package de.bimalo.migration.boundary.services.file;

import de.bimalo.migration.application.MitgliederMigrationRoute;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class ElvisMitgliederXmlFileReader extends RouteBuilder {

    public final static String ROUTE_ID = ElvisMitgliederXmlFileReader.class.getName();
    public final static String ROUTE_URL = "direct:" + ROUTE_ID;

    //spotless:off
    @Override
    public void configure() throws Exception {
        getCamelContext().setUseMDCLogging(true);
        getCamelContext().setUseBreadcrumb(true);

        //from("file:src/test/resources/?fileName=Export-XML-Mitglieder-Alle.xml&charset=ISO-8859-1")
        from("file:src/test/resources/?fileName=Export-XML-Mitglieder-Alle.xml&charset=UTF-8")

                .routeId(ROUTE_ID)
                .setHeader(Exchange.BREADCRUMB_ID, simple("date:now:YYYYMMddHH:mm:ss"))

                .log(LoggingLevel.INFO, "============ BEGIN: docnum=${header.breadcrumbId} file=${file:name} ============ ")

                .to(MitgliederMigrationRoute.ROUTE_URL)

                .to("file:src/test/resources/?fileName=result.csv")

                .log(LoggingLevel.INFO, "============ FINISHED: docnum=${header.breadcrumbId} file=${file:name} ============ ");

    }
    //spotless:on
}