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
    private static final Formular f1 = new Formular(s1, "Formular1", "d1");
    private static final Dokument d2 = new Dokument("Röntgen", ".jpeg", "10.10.2010", "PC/Downloads/Röntgen.jpeg");
    private static final Formular f2 = new Formular(s2, "Formular2", "d2");

    public DatenVerwaltung erstellen(){
        doks.add(d1);
        doks.add(d2);
        form.add(f1);
        form.add(f2);
        DatenVerwaltung datenVerwaltungZiel = new DatenVerwaltung(doks, form);
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
        List<Formular> emptyForm = new ArrayList<>();

        DatenVerwaltung datenVerwaltung = new DatenVerwaltung(emptyDoks, emptyForm);
        datenVerwaltung.setDokument(d1, s1, "Formular1", "d1");
        datenVerwaltung.setDokument(d2, s2, "Formular2", "d2");

        Assertions.assertEquals(datenVerwaltungZiel.hashCode(), datenVerwaltung.hashCode());
    }
}
