package de.bimalo.migration.application;

import de.bimalo.migration.entity.elvis.ElvisMitgliedWithIban;
import de.bimalo.migration.entity.elvis.Mitglieder;
import de.bimalo.migration.entity.kurabu.KurabuMitglied;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.BindyType;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public final class MitgliederMigrationRoute extends RouteBuilder {

    public final static String ROUTE_ID = MitgliederMigrationRoute.class.getName();
    public final static String ROUTE_URL = "direct:" + ROUTE_ID;

    //spotless:off
    @Override
    public void configure() throws Exception {

        JaxbDataFormat jaxbDataFormat = new JaxbDataFormat();
        jaxbDataFormat.setContextPath(Mitglieder.class.getPackage().getName());
        jaxbDataFormat.setSchemaLocation("schemas/Elvis-Mitglieder.xsd");

        from(ROUTE_URL)
                .routeId(ROUTE_ID)
                .errorHandler(noErrorHandler()) //propagate errors to the parent route
                .log(LoggingLevel.INFO, "START: " + ROUTE_ID + " called...")

                .log(LoggingLevel.DEBUG, "Unmarshal Mitglieder from ELVIS to POJO ...")
                .unmarshal(jaxbDataFormat)

                //.bean(new BeitragsklassenAnalyzer(), "analyze")
                //.bean(new AbteilungenAnalyzer(), "analyze")
                //.bean(new KommunikationAnalyzer(), "analyze")
                //.bean(new BankdatenAnalyzer(), "analyze")
                //.bean(new ElvisToKurabuMitgliederMapper(), "map")
                //.log(LoggingLevel.INFO, "${body}")

                .enrich(MitgliederIbanDataRoute.ROUTE_URL, new AggregationStrategy() {
                    @Override
                    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
                        Mitglieder elvisMitglieder = oldExchange.getIn().getBody(Mitglieder.class);

                        List<ElvisMitgliedWithIban> elvisMitgliederIbanListe = newExchange.getIn().getBody(List.class);

                        ElvisToKurabuMitgliederMapper mapper = new ElvisToKurabuMitgliederMapper();
                        mapper.setElvisMitgliederIbanListe(elvisMitgliederIbanListe);
                        List<KurabuMitglied> kurabuMitglieder = mapper.map(elvisMitglieder);

                        newExchange.getIn().setBody(kurabuMitglieder);

                        return newExchange;
                    }
                })

                .marshal().bindy(BindyType.Csv, KurabuMitglied.class);

                /*
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Test");
                    }
                })*/


    }
    //spotless:on
}
