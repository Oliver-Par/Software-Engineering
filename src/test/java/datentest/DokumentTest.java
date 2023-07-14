package datentest;

import daten.Dokument;
import daten.Formular;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DokumentTest {
    private final Dokument dokument = new Dokument("Testdokument", "PDF", "2023-06-24", "Pfad");


   /* @Test
    public void testGetName() {
        assertEquals("Testdokument", dokument.getName

                ());
    }

    @Test
    public void testGetDatentyp() {
        assertEquals("PDF", dokument.getDatentyp());
    }

    @Test
    public void testGetDatum() {
        assertEquals("2023-06-24", dokument.getDatum());
    }

    @Test
    public void testGetDateipfad() {
        assertEquals("Pfad", dokument.getDateipfad());
    }*/

    @Test
    public void testSetFormular() {
        String[] keywords = {"keyword1", "keyword2"};
        Formular formular = dokument.setFormular(keywords, "Bezeichnung", "Wert");

        assertEquals(keywords, formular.getKeyword());
        assertEquals("Bezeichnung", formular.getBezeichnung());
        assertEquals("Wert", formular.getWert());
        assertEquals(formular, dokument.getFormular());
    }

    @Test

    public void testToString() {
        String expected = "Testdokument, PDF, 2023-06-24, Pfad";
        assertEquals(expected, dokument.toString());
    }
}
