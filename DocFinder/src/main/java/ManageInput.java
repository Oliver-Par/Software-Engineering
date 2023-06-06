public interface ManageInput {
    Dokument[] sucheDokument(String[] suchParameter);

    void erstellePfadabfrage(String auswahl);

    void dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad);

    void erstelleKeywordAbfrage();

    boolean bestaetigung();

    String suchergebnisAnzeigen(Dokument[] zutreffendeDokuments);

    void dateiOeffnen(Dokument dokument);

    void dateiLoeschen(Dokument dokument);
}
