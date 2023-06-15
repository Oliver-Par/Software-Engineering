package system;

import daten.DatenVerwaltung;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EingabeVerarbeitung implements ManageInput, Serializable {
    private List<daten.Dokument> dokuments= new ArrayList<>();
    private String dateipfad;
    private String[][] keywords;
    private String[] bezeichnung;
    private String[] wert;
    DatenVerwaltung datenVerwaltung = new DatenVerwaltung(dokuments,keywords,bezeichnung,wert);

    public EingabeVerarbeitung(String dateipfad){
        this.dateipfad = dateipfad;
    }

    public daten.Dokument[] sucheDokument(String[] suchParameter) {
        return new daten.Dokument[0];
    }

    public void erstellePfadabfrage(String auswahl) {
        //Scanner sc = new Scanner(System.in);
        //   String auswahl = sc.nextInt();

    }


        public void dokumentHinzufuegenNachUser (String name, String datentyp, String datum, String dateipfad, String[] keywords, String bezeichnungFormular, String wertFormular){
        try{
        datenVerwaltung.setDokument(new daten.Dokument(name, datentyp, datum, dateipfad), keywords, bezeichnungFormular, wertFormular);
        datenVerwaltung.saveData();
    }catch(NullPointerException e){
            System.out.println("Das Dokument ist leer oder nicht vorhanden.");
        }
    }

    public void erstelleKeywordAbfrage() {

    }

    public boolean bestaetigung() {
        return false;
    }

    public String suchergebnisAnzeigen(daten.Dokument[] zutreffendeDokumente) {
        return null;
    }

    public void dateiOeffnen(daten.Dokument dokument) {

    }
    public void dateiLoeschen(daten.Dokument dokument) {

    }
}