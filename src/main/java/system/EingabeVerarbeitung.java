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

    /**
     * Die Methode bekommt die aufgelisteten Parameter übergeben.
     * Dann wird die Liste an Dokumenten mit datenVerwaltung.readData() ausgegeben.
     * Mit der Methode "setDokument" wird ein Dokument erstellt damit es zum Schluss mit der Methode
     * datenverwaltung.savedata() gespeichert werden kann.
     *
     * @param name                Der Name des Dokumentes.
     * @param datentyp            Der Datentyp des Dokumentes.
     * @param datum               Das Datum des Dokumentes.
     * @param dateipfad           Der Dateipfad des Dokumentes.
     * @param keywords            Die Keywords des Dokumentes.
     * @param bezeichnungFormular Die Bezeichnung des Formulares.
     * @param wertFormular        Der Wert des Formulares.
     * @return true wenn das Speichern erfolgreich war, sonst false.
     */
    public boolean dokumentHinzufuegenNachUser(String name, String datentyp, String datum, String dateipfad, String[] keywords, String bezeichnungFormular, String wertFormular) {
        datenVerwaltung.setDokument(new daten.Dokument(name, datentyp, datum, dateipfad), keywords, bezeichnungFormular, wertFormular);
        return datenVerwaltung.saveData();
    }

    /**
     * Die Methode bestaetigung gibt false aus.
     *
     * @return false
     */
    public boolean bestaetigung() {
        return false;
    }

    /**
     * Es werden der Methode zutreffendeKeywords übergeben.
     * Für jedes Dokument werden die Formular und dann deren FormularKeywords gespeichert.
     * Die Keywords werden auf übereinstimmung verglichen und wenn es einen treffer gibt wird
     * der Liste aus Dokumenten das document hinzugefügt.
     *
     * @param zutreffendeKeywords
     * @return die auf die Keywords zutreffenden Dokumente
     */
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