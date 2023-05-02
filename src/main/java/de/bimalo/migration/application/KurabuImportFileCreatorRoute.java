package de.bimalo.migration.application;

import de.bimalo.migration.entity.MappingResult;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public final class KurabuImportFileCreatorRoute extends RouteBuilder {

    public final static String ROUTE_ID = KurabuImportFileCreatorRoute.class.getName();
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
                        List<MappingResult<Mitglieder.Mitglied, KurabuMitglied>> mappingResults = (List<MappingResult<Mitglieder.Mitglied, KurabuMitglied>>) exchange.getIn().getBody();
                        List<KurabuMitglied> kurabuMitglieder = mappingResults.stream().filter(r -> !r.failed()).map(r -> r.getTarget().get()).collect(Collectors.toList());
                        exchange.getIn().setBody(kurabuMitglieder);
                    }
                 })

                .marshal().bindy(BindyType.Csv, KurabuMitglied.class)
                .to("file:src/test/resources/?fileName=kurabu-import.csv")

                .log(LoggingLevel.INFO, "FINISHED: " + ROUTE_ID + ".");
    }
    //spotless:on
}
