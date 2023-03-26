package de.bimalo.migration.application;

import de.bimalo.migration.entity.ReportEntry;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public final class ReportFileCreatorRoute extends RouteBuilder {

    public final static String ROUTE_ID = ReportFileCreatorRoute.class.getName();
    public final static String ROUTE_URL = "direct:" + ROUTE_ID;

    //spotless:off
    @Override
    public void configure() throws Exception {

        from(ROUTE_URL)
                .routeId(ROUTE_ID)
                .errorHandler(noErrorHandler()) //propagate errors to the parent route
                .log(LoggingLevel.INFO, "START: " + ROUTE_ID + " called...")

                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("xx");
                    }
                })
                .bean(new ReportBuilder(), "build")

                .marshal().bindy(BindyType.Csv, ReportEntry.class)
                .to("file:src/test/resources/?fileName=report.csv")

                .log(LoggingLevel.INFO, "FINISHED: " + ROUTE_ID + ".");
    }
    //spotless:on

}
