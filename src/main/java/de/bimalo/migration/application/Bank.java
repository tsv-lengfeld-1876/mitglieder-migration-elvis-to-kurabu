package de.bimalo.migration.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Bank {
  SPARKASSE_WUERZBURG("Sparkasse Mainfranken, Würzburg", "79050000"),
  TARGOBANK_DUESSELDORF("Targobank Düsseldorf", "30020900"),
  DEUTSCHE_BANK_24("Deutsche Bank 24", "79070024"),
  RAIFFEISENBANK_KUERNACH("Raiffeisenbank Estenf.-Kürnach", "79063060"),
  SPARKASSE_HARZ("Sparkasse Harz", "26351015"),
  VR_BANK_WUERZBURG("V+R Bank Würzburg", "79090000"),
  PSD_BANK_NUERNBERG("PSD-Bank Nürnberg", "76090900"),
  SPARDA_BANK_NUERNBERG("Sparda Bank Nürnberg", "76090500"),
  DEUTSCHE_KREDIT_BANK_SUHL("Dt.Kreditbank Berlin-Suhl AG", "12030000"),
  DEUTSCHE_BANK_BERLIN("Deutsche Bank Berlin", "10070000"),
  DEUTSCHE_BANK_BONN("Deutsche Bank Bonn", "38070024"),
  DEUTSCHE_BANK_MANNHEIM("Deutsche Bank Bonn", "67070010"),
  DEUTSCHE_BANK("Deutsche Bank", "79070016"),
  DEUTSCHE_BANK_HANNOVER("Deutsche Bank Hannover", "5070024"),
  SPARKASSE_HEIDENHEIM("Sparkasse Heidenheim", "63250030"),
  KREISSPARKASSE_OSTALB("Kreissparkasse Ostalb", "61450050");

  /*
      2023-01-16 21:01:55,112 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Service Credit Union Bank
              2023-01-16 21:01:55,112 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR-Bank Altenburgerland Skatbank
              2023-01-16 21:01:55,112 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Einbeck
              2023-01-16 21:01:55,115 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Hof
              2023-01-16 21:01:55,115 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Frankfurter Volksbank
              2023-01-16 21:01:55,115 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank Bonn
              2023-01-16 21:01:55,116 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank
              2023-01-16 21:01:55,116 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse G�ppingen
              2023-01-16 21:01:55,117 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR Bank Werdenfels
              2023-01-16 21:01:55,117 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Bamberg
              2023-01-16 21:01:55,117 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Merkur Privatbank
              2023-01-16 21:01:55,118 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hamburger Sparkasse
              2023-01-16 21:01:55,118 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Oberhessen
              2023-01-16 21:01:55,118 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Rh�n  Rennsteig
              2023-01-16 21:01:55,118 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Comdirect Bank
              2023-01-16 21:01:55,119 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank Nbg. Land
              2023-01-16 21:01:55,119 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Santander Bank
              2023-01-16 21:01:55,119 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR Bank Niederb. Oberpfalz
              2023-01-16 21:01:55,119 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank Würzburg
              2023-01-16 21:01:55,119 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hypovereinsbank Coburg
              2023-01-16 21:01:55,120 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hypovereinsbank Erlangen
              2023-01-16 21:01:55,120 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Neu-Ulm Illertissen
              2023-01-16 21:01:55,120 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Consorsbank
              2023-01-16 21:01:55,120 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) MLP-Bank
              2023-01-16 21:01:55,121 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank
              2023-01-16 21:01:55,121 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Commerbank Würzburg
              2023-01-16 21:01:55,121 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) N26 Bank
              2023-01-16 21:01:55,121 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Bayer.HypoVereinsbank Würzburg
              2023-01-16 21:01:55,121 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Edekabank
              2023-01-16 21:01:55,122 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Berliner Sparkasse
              2023-01-16 21:01:55,122 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Holstein
              2023-01-16 21:01:55,122 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse
              2023-01-16 21:01:55,122 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Vereinte Volksbank M�nster
              2023-01-16 21:01:55,122 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Osnabr�ck
              2023-01-16 21:01:55,123 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Bad Kissingen
              2023-01-16 21:01:55,123 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Bayerische Vereinsbank
              2023-01-16 21:01:55,123 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank Uffenheim-Neustadt
              2023-01-16 21:01:55,123 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Combdirekt Bank
              2023-01-16 21:01:55,124 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank Mannheim
              2023-01-16 21:01:55,124 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) V+R Bank Würzburg
              2023-01-16 21:01:55,124 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparda Bank Nürnberg
              2023-01-16 21:01:55,124 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Schweinfurt
              2023-01-16 21:01:55,125 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparda Bank Augsburg
              2023-01-16 21:01:55,125 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisen-Volksbank Donauw�rth
              2023-01-16 21:01:55,125 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Postscheckamt
              2023-01-16 21:01:55,125 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Hannover
              2023-01-16 21:01:55,125 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Comdirekt Bank
              2023-01-16 21:01:55,126 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank Hannover
              2023-01-16 21:01:55,126 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Postgiroamt Stuttgart
              2023-01-16 21:01:55,126 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Ostalb
              2023-01-16 21:01:55,126 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Unna
              2023-01-16 21:01:55,126 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank Gerolzhofen u.Umg.
              2023-01-16 21:01:55,127 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Weilburg
              2023-01-16 21:01:55,127 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Harz
              2023-01-16 21:01:55,127 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Liga Spar- und Kreditgenossen- sc
              2023-01-16 21:01:55,127 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR-Bank Nord Rh�n
              2023-01-16 21:01:55,127 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Forchheim
              2023-01-16 21:01:55,128 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR-Bank Schw�b. Hall-Crailsh.
              2023-01-16 21:01:55,128 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Essen
              2023-01-16 21:01:55,128 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volksbank Main-Tauber e.G.
              2023-01-16 21:01:55,128 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR-Bank Mittelfranken West
              2023-01-16 21:01:55,128 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) GLS Gemeinschaftsbank
              2023-01-16 21:01:55,129 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank Varel-Nordenham
              2023-01-16 21:01:55,129 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank Estenf.-Kürnach
              2023-01-16 21:01:55,129 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Gro�-Gerau
              2023-01-16 21:01:55,129 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Mainfranken, Würzburg
              2023-01-16 21:01:55,129 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR Bank Frankenwinheim
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volksbank Weinheim
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Aschaffenburg
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) VR-Bank  Weimar
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiba Abstwind-Prichs-R�denh- W'b
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Hohenlohekreis
              2023-01-16 21:01:55,130 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volksbank Kitzingen
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Worms-Alzey-Ried
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Evangelische Bank
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Vereinete Sparkassen Ansbach
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Memmingen-Mindelheim
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Targobank Düsseldorf
              2023-01-16 21:01:55,131 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volkswagen Bank
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Frankfurt 1822 direkt
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Triodos Bank
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Dt.Apotheker-+�rztebank
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparda Bank Frankfurt
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Schw�b.Hall
              2023-01-16 21:01:55,132 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volksbank Trier
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) PSD-Bank Nürnberg
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiba Karlstadt-Gem�nden
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Niederbayern Mitte
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Oberland
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank T�rkheim
              2023-01-16 21:01:55,133 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Bayer. Vereinsbank
              2023-01-16 21:01:55,134 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Landshut
              2023-01-16 21:01:55,134 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) BW-Bank
              2023-01-16 21:01:55,134 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) St�dt. Sparkasse Nürnberg
              2023-01-16 21:01:55,134 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Direktbank Frankfurt
              2023-01-16 21:01:55,136 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Dresdner Bank Würzburg
              2023-01-16 21:01:55,136 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hypo-Vereinsbank Würzburg
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Mittelfranken-S�d
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank 24
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Bad Neustadt
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Dt.Kreditbank Berlin-Suhl AG
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Hildesheim
              2023-01-16 21:01:55,137 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiba B�tthard
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hypo-Vereinsbank Augsburg
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Consors Bank
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Norisbank
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Hypovereinsbank
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Raiffeisenbank H�chberg und Umg.
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Deutsche Bank Berlin
              2023-01-16 21:01:55,138 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Kreissparkasse Starnberg
              2023-01-16 21:01:55,139 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Volksbank Reutlingen
              2023-01-16 21:01:55,139 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Stadtsparkasse Pegnitz
              2023-01-16 21:01:55,139 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Heidenheim
              2023-01-16 21:01:55,139 INFO  [de.bim.mig.app.BankdatenAnalyzer] (Camel (camel-1) thread #1 - file://src/test/resources/) Sparkasse Ingolstadt
  */
  private String name;
  private String blz;

  public static Bank findBank(String name) {
    for (Bank b : values()) {
      if (b.name.equalsIgnoreCase(name.trim())) {
        return b;
      }
    }
    throw new IllegalArgumentException(String.format("Bank '%s' aus Elvis nicht bekannt.", name));
  }
}
