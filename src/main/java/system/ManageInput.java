package system;

import daten.Dokument;

import java.util.List;

public interface ManageInput {
    daten.Dokument[] sucheDokument(String[] suchParameter);

    void erstellePfadabfrage(String auswahl);

    boolean dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad, String[] keywords, String bezeichnungFormular, String wertFormular);


    boolean bestaetigung();

    List<Dokument> suchergebnisAnzeigen(String[] zutreffendeKeywords);

    void dateiOeffnen(String dokumentenName);

    boolean dateiLoeschen(daten.Dokument dokument);
}