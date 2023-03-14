package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Abteilung {

    FUSSBALL("Fußball", "Fußball-Abteilung", true);

    private String elvisAbteilung;
    private String kurabuAbteilung;
    private boolean migrate;

    public static Abteilung findAbteilungByElvis(String elvisAbteilung) {
        for (Abteilung c : values()) {
            if (c.elvisAbteilung.equals(elvisAbteilung)) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.format("Abteilung %s aus Elvis nicht bekannt.", elvisAbteilung));
    }

}
