package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Beitragsklasse {

    JUDO_ERHOBEN("Judo erhoben", "", false),
    SCHWERBEHINDERTE("Schwerbehinderte", "HV - Schwerbehindertenausweis", true),
    SCHACH_JUGEND("Schach Jugendliche", "Schach - Jugend", true),
    SCHACH_ANTEILIG("Schach anteilig", "", false),
    TT_ERHOBEN("TT erhoben", "", false),
    RENTNER_EINZEL_ARBEITSLOS("Rentner Einzel /Arbeitslose", "Rentner Einzel /Arbeitslose", true),
    SCHACH_ERHOBEN("Schach erhoben", "", false),
    JUDO_JUGEND("Judo Jugend", "Judo - Jugend", true),
    TT_KINDER("TT Kinder", "Tischtennis - Kinder", true),
    FB_ERHOBEN("FB erhoben", "", false),
    BREITENSPORT_ABTEILUNG_BEITRAGSFREI("Breitensport abtl.beitragsfrei", "Breitensport - Beitragsfrei", true),
    HANDBALL_ERHOBEN("Handball erhoben", "", false),
    STUDENTEN_AZUBIS_ERMAESSIGT("Studenten/Azubi ermÃ¯Â¿Â½Ã¯Â¿Â½igt", "HV - Studenten", true),
    BREITENSPORT_ANTEILIG("Breitensport anteilig", "", false),
    VOLLEYBALL_ERHOBEN("Volleyball erhoben", "", false),
    JUDO_ABTEILUNG_BEITRAGSFREI("Judo abteilungsbeitragsfrei", "Judo - Beitragsfrei", true),
    JUGEND_EINZEL("Jugend Einzel", "HV - Jugend", true),
    ALG_II_KINDER("ALG II Kinder", "HV - Beitragsfrei", true),
    FUSSBALL_ERWACHSENE("FB Erwachsene", "Fußball - Erwachsene", true),
    SCHACH_KINDER("Schach Kinder", "Schach - Kinder", true),
    ALG_II_ABTEILUNGSBEITRAG("ALG II Abteilungsbeitrag", "", false),
    BREITENSPORT_ERHOBEN("Breitensport erhoben", "", false),
    KINDER_EINZEL("Kinder Einzel", "HV - Kinder", true),
    JUDO_JAHRESSICHT_MARKE("Judo Jahressichtmarke", "", false),
    VOLLEYBALL_ABTEILUNG_BEITRAGSFREI("Volleyball abtl.beitragsfrei", "Volleyball - Beitragsfrei", true),
    YOGABEITRAG("Yogabeitrag", "", false),
    HANDBALL_JUGEND("Handball Jugendliche", "Handball - Jugend", true),
    SONDERBEITRAG("Sonderbeitrag", "", false),
    FUSSBALL_ALTE_HERREN("FB Alte Herren", "Fußball - Alte Herren", true),
    JUDO_ANTEILIG("Judo anteilig", "", false),
    ABT_B_BEITRAGSFREI("Abt.B.-beitragsfrei", "", false),
    HANDBALL_ABTEILUNG_BEITRAGSFREI("Handball abtl.beitragsfrei", "Handball - Beitragsfrei", true),
    FUSSBALL_ANTEILIG("FB anteilig", "", false),
    JUDO_AUFNAHMEGEBUEHR("Judo AufnahmegebÃ¯Â¿Â½hr", "", false),
    BREITENSPORT_ERWACHSENE("Breitensport Erwachsene", "Breitensport - Erwachsene", true),
    JUDO_KINDER("Judo Kinder", "Judo - Kinder", true),
    FUSSBALL_KINDER("FB Kinder", "Fußball - Kinder", true),
    KEGELN_ANTEILIG("Kegeln anteilig", "", false),
    LA_KINDER("LA Kinder", "Breitensport - Kinder", true),
    KEGELN_JUGEND("Kegeln Jugendliche", "Kegeln - Jugend", true),
    JUDO_ERWACHSENE("Judo Erwachsene", "Judo - Erwachsene", true),
    KEGELN_ABTEILUNG_BEITRAGSFREI("Kegeln abteilungsbeitragsfrei", "Kegeln - Beitragsfrei", true),
    VOLLEYBALL_ERWACHSENE("Volleyball Erwachsene", "Volleyball - Erwachsene", true),
    TT_ERWACHSENE("TT Erwachsene", "Tischtennis - Erwachsene", true),
    FUSSBALL_ABTEILUNG_BEITRAGSFREI("FB abteilungsbeitragsfrei", "Fußball - Beitragsfrei", true),
    KARATE_ERWACHSENE("Karate Erwachsene", "Karate - Erwachsene", true),
    HANDBALL_ANTEILIG("Handball anteilig", "", false),
    TT_ABTEILUNG_BEITRAGSFREI("TT abteilungsbeitragsfrei", "Tischtennis - Beitragsfrei", true),
    KARATE_ABTEILUNG_BEITRAGSFREI("Karate abtl.beitragsfrei", "Karate - Beitragsfrei", true),
    VOLLEYBALL_JUGEND("Volleyball Jugendliche", "Volleyball - Jugend", true),
    HANDBALL_ERWACHSENE("Handball Erwachsene", "Handball - Erwachsene", true),
    KEGELN_ERWACHSENE("Kegeln Erwachsene", "Kegeln - Erwachsene", true),
    TT_ANTEILIG("TT anteilig", "", false),
    RENTNER_EHEPAAR("Rentner Ehepaar", "HV - Rentnerehepaare", true),
    BEITRAGSFREI("beitragsfrei", "", false),
    NUR_VERSICHERUNGSBEITRAG("nur Versicherungsbeitrag", "", false),
    HANDBALL_KINDER("Handball Kinder", "Handball - Kinder", true),
    FUSSBALL_JUGEND("FB Jugentliche", "Fußball - Jugend", true),
    VOLLEYBALL_KINDER("Volleyball Kinder", "Volleyball - Kinder", true),
    ALG_II_JUGENDLICHE("ALG II Jugendliche", "HV - Beitragsfrei", true),
    KEGELN_ERHOBEN("Kegeln erhoben", "", false),
    AUSSIEDLER_BEITRAGSFREI("Aussiedler 1 Jahr beitragsfrei", "HV-Beitragsfrei", true),
    FAMILIEN_BEITRAG("Familienbeitrag", "HV - Familienbeitrag", true),
    FAMILIE_BEITRAGSFREI("beitragsfrei Familie", "HV - Beitragsfrei", true),
    ERWACHSENE_EINZEL("Erwachsener Einzel", "HV - Erwachsene", true),
    SCHACH_ERWACHSENE("Schach Erwachsene", "Schach - Erwachsene", true),
    VOLLEYBALL_ANTEILIG("Volleyball anteilig", "", false),
    SONDERBEITRAG2("Ã¯Â¿Â½L-Sonderbeitrag", "", false),
    SCHACH_ABTEILUNG_BEITRAGSFREI("Schach abteilungsbeitragsfrei", "Schach - Beitragsfrei", true),
    TT_JUGEND("TT Jugendliche", "Tischtennis - Jugend", true),
    KARATE_ANTEILIG("Karate anteilig", "", false),
    BREITENSPORT_KINDER("Breitensport Kinder", "Breitensport - Kinder", true);

    private String elvisBeitrag;
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
}
