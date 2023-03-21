package de.bimalo.migration.application;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Beitragsklasse {

    // Hauptbeitrag
    SCHWERBEHINDERTE("Schwerbehinderte", "HV - Schwerbehindertenausweis", true),
    RENTNER_EINZEL_ARBEITSLOS("Rentner Einzel /Arbeitslose", "HV - Rentner oder Arbeitslose", true),
    STUDENTEN_AZUBIS_ERMAESSIGT("Studenten/Azubi ermäßigt", "HV - Studenten", true),
    JUGEND_EINZEL("Jugend Einzel", "HV - Jugend", true),
    ALG_II_KINDER("ALG II Kinder", "HV - Beitragsfrei", true),
    ALG_II_ABTEILUNGSBEITRAG("ALG II Abteilungsbeitrag", "", false),
    KINDER_EINZEL("Kinder Einzel", "HV - Kinder", true),
    SONDERBEITRAG("Sonderbeitrag", "", false),
    ABT_B_BEITRAGSFREI("Abt.B.-beitragsfrei", "", false),
    RENTNER_EHEPAAR("Rentner Ehepaar", "HV - Rentnerehepaare", true),
    BEITRAGSFREI("beitragsfrei", "", false),
    NUR_VERSICHERUNGSBEITRAG("nur Versicherungsbeitrag", "", false),
    ALG_II_JUGENDLICHE("ALG II Jugendliche", "HV - Beitragsfrei", true),
    AUSSIEDLER_BEITRAGSFREI("Aussiedler 1 Jahr beitragsfrei", "HV - Beitragsfrei", true),
    FAMILIEN_BEITRAG("Familienbeitrag", "HV - Familienbeitrag", true),
    FAMILIE_BEITRAGSFREI("beitragsfrei Familie", "HV - Beitragsfrei", true),
    ERWACHSENE_EINZEL("Erwachsener Einzel", "HV - Erwachsene", true),
    SONDERBEITRAG2("Ã¯Â¿Â½L-Sonderbeitrag", "", false),

    // Abteilungen
    JUDO_ERHOBEN("Judo erhoben", "", false),
    JUDO_JUGEND("Judo Jugend", "Judo - Jugend", true),
    JUDO_ABTEILUNG_BEITRAGSFREI("Judo abteilungsbeitragsfrei", "Judo - Beitragsfrei - aktiv", true),
    JUDO_JAHRESSICHT_MARKE("Judo Jahressichtmarke", "", false),
    JUDO_ANTEILIG("Judo anteilig", "", false),
    JUDO_AUFNAHMEGEBUEHR("Judo AufnahmegebÃ¯Â¿Â½hr", "", false),
    JUDO_KINDER("Judo Kinder", "Judo - Kinder", true),
    JUDO_ERWACHSENE("Judo Erwachsene", "Judo - Erwachsene", true),

    SCHACH_JUGEND("Schach Jugendliche", "Schach - Jugend", true),
    SCHACH_ANTEILIG("Schach anteilig", "", false),
    SCHACH_ERHOBEN("Schach erhoben", "", false),
    SCHACH_KINDER("Schach Kinder", "Schach - Kinder", true),
    SCHACH_ERWACHSENE("Schach Erwachsene", "Schach - Erwachsene", true),
    SCHACH_ABTEILUNG_BEITRAGSFREI("Schach abteilungsbeitragsfrei", "Schach - Beitragsfrei - aktiv", true),

    TT_ERHOBEN("TT erhoben", "", false),
    TT_KINDER("TT Kinder", "Tischtennis - Kinder", true),
    TT_ERWACHSENE("TT Erwachsene", "Tischtennis - Erwachsene", true),
    TT_ABTEILUNG_BEITRAGSFREI("TT abteilungsbeitragsfrei", "Tischtennis - Beitragsfrei - aktiv", true),
    TT_ANTEILIG("TT anteilig", "", false),
    TT_JUGEND("TT Jugendliche", "Tischtennis - Jugend", true),

    FB_ERHOBEN("FB erhoben", "", false),

    BREITENSPORT_ABTEILUNG_BEITRAGSFREI("Breitensport abtl.beitragsfrei", "Breitensport - Beitragsfrei - aktiv", true),
    BREITENSPORT_ANTEILIG("Breitensport anteilig", "", false),
    BREITENSPORT_ERHOBEN("Breitensport erhoben", "", false),
    BREITENSPORT_ERWACHSENE("Breitensport Erwachsene", "Breitensport - Erwachsene", true),
    LA_KINDER("LA Kinder", "Breitensport - Kinder", true),
    BREITENSPORT_KINDER("Breitensport Kinder", "Breitensport - Kinder", true),

    HANDBALL_ERHOBEN("Handball erhoben", "", false),
    HANDBALL_JUGEND("Handball Jugendliche", "Handball - Jugend", true),
    HANDBALL_ABTEILUNG_BEITRAGSFREI("Handball abtl.beitragsfrei", "Handball - Beitragsfrei - aktiv", true),
    HANDBALL_ANTEILIG("Handball anteilig", "", false),
    HANDBALL_ERWACHSENE("Handball Erwachsene", "Handball - Erwachsene", true),
    HANDBALL_KINDER("Handball Kinder", "Handball - Kinder", true),

    FUSSBALL_ERWACHSENE("FB Erwachsene", "Fußball - Erwachsene", true),
    FUSSBALL_ALTE_HERREN("FB Alte Herren", "Fußball - Alte Herren", true),
    FUSSBALL_ANTEILIG("FB anteilig", "", false),
    FUSSBALL_KINDER("FB Kinder", "Fußball - Kinder", true),
    FUSSBALL_ABTEILUNG_BEITRAGSFREI("FB abteilungsbeitragsfrei", "Fußball - Beitragsfrei", true),
    FUSSBALL_JUGEND("FB Jugentliche", "Fußball - Jugend", true),

    VOLLEYBALL_ABTEILUNG_BEITRAGSFREI("Volleyball abtl.beitragsfrei", "Volleyball - Beitragsfrei - aktiv", true),
    VOLLEYBALL_ERWACHSENE("Volleyball Erwachsene", "Volleyball - Erwachsene", true),
    VOLLEYBALL_JUGEND("Volleyball Jugendliche", "Volleyball - Jugend", true),
    VOLLEYBALL_KINDER("Volleyball Kinder", "Volleyball - Kinder", true),
    VOLLEYBALL_ANTEILIG("Volleyball anteilig", "", false),
    VOLLEYBALL_ERHOBEN("Volleyball erhoben", "", false),

    YOGABEITRAG("Yogabeitrag", "Yogabeitrag", false),

    KEGELN_ANTEILIG("Kegeln anteilig", "", false),
    KEGELN_JUGEND("Kegeln Jugendliche", "Kegeln - Jugend", true),
    KEGELN_ABTEILUNG_BEITRAGSFREI("Kegeln abteilungsbeitragsfrei", "Kegeln - Beitragsfrei - aktiv", true),
    KEGELN_ERWACHSENE("Kegeln Erwachsene", "Kegeln - Erwachsene", true),
    KEGELN_ERHOBEN("Kegeln erhoben", "", false),

    KARATE_ERWACHSENE("Karate Erwachsene", "Karate - Erwachsene", true),
    KARATE_ABTEILUNG_BEITRAGSFREI("Karate abtl.beitragsfrei", "Karate - Beitragsfrei - aktiv", true),
    KARATE_ANTEILIG("Karate anteilig", "", false);

    @Getter
    private String elvisBeitrag;
    @Getter
    private String kurabuBeitrag;
    private boolean migrate;

    public static Beitragsklasse findBeitragsklasseByElvis(String elvisBeitrag) {
        for (Beitragsklasse c : values()) {
            if (c.elvisBeitrag.equals(elvisBeitrag)) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.format("Beitragsklasse %s aus Elvis nicht bekannt.", elvisBeitrag));
    }

    public boolean mustBeMigrated() {
        return migrate;
    }

}
