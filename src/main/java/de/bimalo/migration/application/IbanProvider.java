package de.bimalo.migration.application;

import de.bimalo.migration.entity.sepa.*;
import lombok.NonNull;
import lombok.extern.java.Log;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

@Log
final class IbanProvider {

    private Document doc;

    public IbanProvider(Document doc) {
       this.doc = doc;
    }

    public String findIban(@NonNull String givenName, @NonNull String lastName) {
        String iban = null;

        
        DirectDebitTransactionInformation9 debitor = doc.getCstmrDrctDbtInitn().getPmtInf().get(0).getDrctDbtTxInf().stream().filter(d -> String.format("%s, %s", lastName, givenName).equalsIgnoreCase(d.getDbtr().getNm())).findAny().orElse(null);
        if (debitor != null) {
            iban = debitor.getDbtrAcct().getId().getIBAN();
        }

        return iban;
    }

    public static IbanProvider get(@NonNull URL urlToFile) {
        try {
            File file = new File(urlToFile.getFile());
            InputStream inStream = new FileInputStream(file);
            Document doc = unmarshal(inStream);
            return new IbanProvider(doc);
        }
        catch(FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Document unmarshal(InputStream inStream) {
        try {
            Unmarshaller jaxbUnmarshaller = buildUnmarshaller();
             JAXBElement<Document> root = jaxbUnmarshaller.unmarshal(new StreamSource(inStream), Document.class);
            return root.getValue();

        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Unmarshaller buildUnmarshaller() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            return jaxbContext.createUnmarshaller();
        } catch (JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }

  
}
