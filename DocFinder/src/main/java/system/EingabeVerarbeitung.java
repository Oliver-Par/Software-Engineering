package system;

import daten.DatenVerwaltung;
import daten.Dokument;
import daten.Formular;

import java.util.ArrayList;
import java.util.List;

public class EingabeVerarbeitung implements ManageInput {
    private List<daten.Dokument> dokuments;
    private String dateipfad;
    private String[][] keywords;
    private String[] bezeichnung;
    private String[] wert;
    DatenVerwaltung datenVerwaltung = new DatenVerwaltung(dokuments, keywords, bezeichnung, wert);


    public daten.Dokument[] sucheDokument(String[] suchParameter) {
        return new daten.Dokument[0];
    }

    public void erstellePfadabfrage(String auswahl) {
        //Scanner sc = new Scanner(System.in);
        //   String auswahl = sc.nextInt();

    }

    public void dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad, String[] keywords, String bezeichnungFormular, String wertFormular) {
        datenVerwaltung.readData();
        datenVerwaltung.setDokument(new daten.Dokument(name, datentyp, datum, dateipfad), keywords, bezeichnungFormular, wertFormular);
        datenVerwaltung.saveData();
    }

    public void erstelleKeywordAbfrage() {

    }

    public boolean bestaetigung() {
        return false;
    }

    public List<Dokument> suchergebnisAnzeigen(String[] zutreffendeKeywords) {
        List<Dokument> dokuments1 = datenVerwaltung.readData();
        boolean treffer = false;
        List<Dokument> zutreffendeDocuments = new ArrayList<>();
        for (Dokument document : dokuments1) {
            Formular formular = document.getFormular();
            String[] formularKeywords = formular.getKeyword();
            for (int n = 0; n < 5; n++) {
                if (!zutreffendeKeywords[n].equals("") || zutreffendeKeywords[n] != null) {
                    if (zutreffendeKeywords[n].equals(formularKeywords[n]) || zutreffendeKeywords[n].equals("")) {
                        treffer = true;
                    } else {
                        treffer = false;
                        break;
                    }
                }
            }
            if (treffer) {
                zutreffendeDocuments.add(document);
            }
        }
        return zutreffendeDocuments;
    }

    public void dateiOeffnen(daten.Dokument dokument) {

    }

    public void dateiLoeschen(daten.Dokument dokument) {

    }
}
