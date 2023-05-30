public interface ManageInput {
    Node[] sucheDokument(String[] suchParameter);

    void erstellePfadabfrage(String auswahl);

    void addNode(String auswahl);

    void erstelleKeywordAbfrage();

    boolean bestaetigung();

    String suchergebnisAnzeigen(Node[] zutreffendeNodes);

    void dateiOeffnen(Node node);

    void dateiLoeschen(Node node);
}
