Übung 3

Diese Übung wird ganz simpel initialisiert:

    Rennstrecke rennstrecken[] = {
        rennSimulator.registriereRennstrecke("Kurze Strecke", 75),
        rennSimulator.registriereRennstrecke("Mittlere Strecke", 100),
        rennSimulator.registriereRennstrecke("Lange Strecke", 125),
        rennSimulator.registriereRennstrecke("Extra lange Strecke", 150)
    };

    Schnecke schnecken[] = {
        rennSimulator.registriereSchnecke("Schnecke 1"),
        rennSimulator.registriereSchnecke("Schnecke 2"),
        rennSimulator.registriereSchnecke("Schnecke 3"),
        rennSimulator.registriereSchnecke("Schnecke 4"),
        rennSimulator.registriereSchnecke("Schnecke 5"),
        rennSimulator.registriereSchnecke("Schnecke 6"),
        rennSimulator.registriereSchnecke("Schnecke 7"),
        rennSimulator.registriereSchnecke("Schnecke 8"),
        rennSimulator.registriereSchnecke("Schnecke 9"),
        rennSimulator.registriereSchnecke("Schnecke 10"),
        rennSimulator.registriereSchnecke("Schnecke 11"),
        rennSimulator.registriereSchnecke("Schnecke 12"),
        rennSimulator.registriereSchnecke("Schnecke 13"),
        rennSimulator.registriereSchnecke("Schnecke 14"),
        rennSimulator.registriereSchnecke("Schnecke 15"),
        rennSimulator.registriereSchnecke("Schnecke 16"),
        rennSimulator.registriereSchnecke("Schnecke 17")
    };

    Rennen rennen[] = {
        rennSimulator.registriereRennen("Rennen 1", rennstrecken[0], new Schnecke[] { schnecken[0], schnecken[1], schnecken[3] }),
        rennSimulator.registriereRennen("Rennen 2", rennstrecken[0], new Schnecke[] { schnecken[2], schnecken[3], schnecken[4] }),
        rennSimulator.registriereRennen("Rennen 3", rennstrecken[1], new Schnecke[] { schnecken[2], schnecken[3], schnecken[4] }),
        rennSimulator.registriereRennen("Rennen 4", rennstrecken[1], new Schnecke[] { schnecken[4], schnecken[5], schnecken[6] })
    };

    Person personen[] = {
        rennSimulator.getWettbüro().registrierePerson("Person 1", 1234),
        rennSimulator.getWettbüro().registrierePerson("Person 2", 12345),
        rennSimulator.getWettbüro().registrierePerson("Person 3", 123),
        rennSimulator.getWettbüro().registrierePerson("Person 4", 4444),
        rennSimulator.getWettbüro().registrierePerson("Person 5", 1500),
        rennSimulator.getWettbüro().registrierePerson("Person 6", 8123),
        rennSimulator.getWettbüro().registrierePerson("Person 7", 1000),
        rennSimulator.getWettbüro().registrierePerson("Person 8", 5555)
    };

    rennSimulator.getWettbüro().wetteAbschließen(personen[0], rennen[0], rennen[0].schnecken[0], 100);
    rennSimulator.getWettbüro().wetteAbschließen(personen[1], rennen[0], rennen[0].schnecken[0], 100);
    rennSimulator.getWettbüro().wetteAbschließen(personen[2], rennen[0], rennen[0].schnecken[0], 100);
    rennSimulator.getWettbüro().wetteAbschließen(personen[3], rennen[0], rennen[0].schnecken[0], 100);

Das Ergebnis sieht wie folgt aus:

![Demo outout](https://raw.githubusercontent.com/0xFEEDC0DE64/PGTL-Programs/master/src/ninja/brunner/pgtl/program3/screenshot.png)