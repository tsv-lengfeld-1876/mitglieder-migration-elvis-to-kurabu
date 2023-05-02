package de.bimalo.migration.application;

import de.bimalo.migration.entity.Abteilungszuordnung;
import de.bimalo.migration.entity.ReportEntry;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class AbteilungszuordnungFileCreatorRoute extends RouteBuilder {

    public final static String ROUTE_ID = AbteilungszuordnungFileCreatorRoute.class.getName();
    public final static String ROUTE_URL = "direct:" + ROUTE_ID;

    //spotless:off
    @Override
    public void configure() throws Exception {

        from(ROUTE_URL)
                .routeId(ROUTE_ID)
                .errorHandler(noErrorHandler()) //propagate errors to the parent route
                .log(LoggingLevel.INFO, "START: " + ROUTE_ID + " called...")

                .bean(new AbteilungszuordnungBuilder(), "build")

                .marshal().bindy(BindyType.Csv, Abteilungszuordnung.class)
                .to("file:src/test/resources/?fileName=Abteilungszuordnung.csv")

                .log(LoggingLevel.INFO, "FINISHED: " + ROUTE_ID + ".");
    }
    //spotless:on

}
