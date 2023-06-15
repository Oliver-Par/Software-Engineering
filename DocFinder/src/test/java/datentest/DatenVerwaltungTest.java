package datentest;

import daten.DatenVerwaltung;
import daten.Dokument;
import daten.Formular;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
public class DatenVerwaltungTest {
    private static final List<Dokument> doks = new ArrayList<>();
    private static final List<Formular> form = new ArrayList<>();
    private static final String[] s1 = new String[] {"Blut", "Herr Mayer", "22.03.2016", "pdf"};
    private static final String[] s2 = new String[] {"Röntgen", "Dr Marx", "10.10.2010", "jpeg"};
    private static final Dokument d1 = new Dokument("Blutblid", ".pdf", "22.03.2016", "PC/Dokument/Blutbild.pdf");
    private static final String[][] keywords = new String[][] {s1, s2};
    private static final String[] bezeichnung = new String[] {"Formular 1", "Formular 2"};
    private static final String[] wert = new String[] {"d1", "d2"};
    private static final Dokument d2 = new Dokument("Röntgen", ".jpeg","10.10.2010", "PC/Downloads/Röntgen.jpeg");


    public DatenVerwaltung erstellen(){
        doks.add(d1);
        doks.add(d2);
        DatenVerwaltung datenVerwaltungZiel = new DatenVerwaltung(doks, keywords, bezeichnung, wert);
        return datenVerwaltungZiel;
    }

    @Test
    void testGetDokument(){
        DatenVerwaltung datenVerwaltung = erstellen();
        List<Dokument> dokumentsVonDatenVerwaltung = datenVerwaltung.getDokument();

        Assertions.assertArrayEquals(doks.toArray(), dokumentsVonDatenVerwaltung.toArray());
    }

    @Test
    void testSetDokument(){
        DatenVerwaltung datenVerwaltungZiel = erstellen();
        List<Dokument> emptyDoks = new ArrayList<>();
        String[][] emptyKeywords = new String[0][];
        String[] emptyBezeichnung = new String[0];
        String[] emptyWert = new String[0];

        DatenVerwaltung datenVerwaltung = new DatenVerwaltung(emptyDoks, emptyKeywords, emptyBezeichnung, emptyWert);
        datenVerwaltung.setDokument(d1, s1, "Formular1", "d1");
        datenVerwaltung.setDokument(d2, s2, "Formular2", "d2");

        Assertions.assertEquals(datenVerwaltungZiel.hashCode(), datenVerwaltung.hashCode());
    }
}
