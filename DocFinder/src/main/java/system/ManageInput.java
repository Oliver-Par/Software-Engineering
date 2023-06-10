package system;

public interface ManageInput {
    daten.Dokument[] sucheDokument(String[] suchParameter);

    void erstellePfadabfrage(String auswahl);

    void dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad, String[] keywords, String bezeichnungFormular, String wertFormular);

    void erstelleKeywordAbfrage();

    boolean bestaetigung();

    String suchergebnisAnzeigen(daten.Dokument[] zutreffendeDokuments);

    void dateiOeffnen(daten.Dokument dokument);

    void dateiLoeschen(daten.Dokument dokument);
}