package daten;

import java.io.Serializable;

public class Dokument implements Serializable {
    private final String name;
    private final String datentyp;
    private final String datum;
    private final String dateipfad;

    private Formular formular;

    public Dokument(String name, String datentyp, String datum, String dateipfad) {
        this.name = name;
        this.datentyp = datentyp;
        this.datum = datum;
        this.dateipfad = dateipfad;
    }
    public String getName() {
        return name;
    }

    public String getDatentyp() {
        return datentyp;
    }

    public String getDatum() {
        return datum;
    }

    public String getDateipfad() {
        return dateipfad;
    }

    public Formular getFormular() {
        return formular;
    }

    public Formular setFormular(String[] keyword, String bezeichnung, String wert) {
        formular = new Formular(keyword, bezeichnung, wert);
        return formular;
    }

    public String toString() {
        return name + ", " + datentyp + ", " + datum + ", " + dateipfad;
    }
}
