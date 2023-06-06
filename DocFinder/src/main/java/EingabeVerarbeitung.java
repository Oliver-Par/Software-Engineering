import java.util.List;
import java.util.Scanner;
public class EingabeVerarbeitung implements ManageInput{
    private List<Dokument> dokuments;
    private String dateipfad;
    DatenVerwaltung datenVerwaltung = new DatenVerwaltung();

    public EingabeVerarbeitung(List<Dokument> dokuments, String dateipfad){
        this.dokuments = dokuments;
        this.dateipfad = dateipfad;
    }

    public Dokument[] sucheDokument(String[] suchParameter) {
        return new Dokument[0];
    }

    public void erstellePfadabfrage(String auswahl) {
        //Scanner sc = new Scanner(System.in);
        //   String auswahl = sc.nextInt();

    }

    public void dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad) {
        datenVerwaltung.setDokument(new Dokument(name, datentyp, datum, dateipfad));
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
