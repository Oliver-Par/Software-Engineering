package daten;

import daten.Formular;

import java.io.Serializable;

public class Dokument implements Serializable {
    private String name;
    private String datentyp;
    private String datum;
    private String dateipfad;

    private Formular formular;

    public Dokument(String name, String datentyp, String datum, String dateipfad){
        this.name = name;
        this.datentyp = datentyp;
        this.datum = datum;
        this.dateipfad = dateipfad;
    }
    public Formular getFormular() {
        return this.formular;
    }

    public Formular setFormular(String[] keyword, String bezeichnung, String wert) {
        this.formular = new Formular(keyword, bezeichnung, wert);
        return formular;
    }

    public String toString(){
        return name + ", " + datentyp + ", " + datum + ", " + dateipfad;
    }
}
