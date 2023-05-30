public class EingabeVerarbeitung implements ManageInput{
    private Node[] nodes;

    private String dateipfad;

    public EingabeVerarbeitung(Node[] nodes, String dateipfad){
        this.nodes = nodes;
        this.dateipfad = dateipfad;
    }


    @Override
    public Node[] sucheDokument(String[] suchParameter) {
        return new Node[0];
    }

    @Override
    public void erstellePfadabfrage(String auswahl) {

    }

    @Override
    public void addNode(String auswahl) {

    }

    @Override
    public void erstelleKeywordAbfrage() {

    }

    @Override
    public boolean bestaetigung() {
        return false;
    }

    @Override
    public String suchergebnisAnzeigen(Node[] zutreffendeNodes) {
        return null;
    }

    @Override
    public void dateiOeffnen(Node node) {

    }

    @Override
    public void dateiLoeschen(Node node) {

    }
}
