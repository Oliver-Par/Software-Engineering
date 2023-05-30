public class EingabeVerarbeitung implements ManageInput{
    private Dokument[] dokument;

    private String dateipfad;

    public EingabeVerarbeitung(Dokument[] dokument, String dateipfad){
        this.dokument = dokument;
        this.dateipfad = dateipfad;
    }

    public Dokument[] sucheDokument(String[] suchParameter) {
        return new Dokument[0];
    }

    public void erstellePfadabfrage(String auswahl) {

    }

    public void DokumentHinzufuegenNachUser(String auswahl) {

    }

    public void erstelleKeywordAbfrage() {

    }

    public boolean bestaetigung() {
        return false;
    }

    public String suchergebnisAnzeigen(Dokument[] zutreffendeDokumente) {
        return null;
    }

    public void dateiOeffnen(Dokument dokument) {

    }
    public void dateiLoeschen(Dokument dokument) {

    }
}
