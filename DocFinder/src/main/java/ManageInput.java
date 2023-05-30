public interface ManageInput {
    Dokument[] sucheDokument(String[] suchParameter);

    void erstellePfadabfrage(String auswahl);

    void DokumentHinzufuegenNachUser(String auswahl);

    void erstelleKeywordAbfrage();

    boolean bestaetigung();

    String suchergebnisAnzeigen(Dokument[] zutreffendeDokuments);

    void dateiOeffnen(Dokument dokument);

    void dateiLoeschen(Dokument dokument);
}
