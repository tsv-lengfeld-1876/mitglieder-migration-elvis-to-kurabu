package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.ElvisMitgliedWithIban;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class MitgliederIbanDataRoute extends RouteBuilder {

    public final static String ROUTE_ID = MitgliederIbanDataRoute.class.getName();
    public final static String ROUTE_URL = "direct:" + ROUTE_ID;

    //spotless:off
     @Override
    public void configure() throws Exception {

         DataFormat mitgliederIbanFormat = new BindyCsvDataFormat(ElvisMitgliedWithIban.class);

         from(ROUTE_URL)
                 .routeId(ROUTE_ID)
                 .errorHandler(noErrorHandler()) //propagate errors to the parent route
                 .log(LoggingLevel.INFO, "START: " + ROUTE_ID + " called...")
                 .pollEnrich("file:src/test/resources/?fileName=Mitglieder-mit-IBAN.csv&noop=true")
                    .unmarshal(mitgliederIbanFormat)
                  .log(LoggingLevel.INFO, "FINISHED: " + ROUTE_ID + ".");
     }
}
