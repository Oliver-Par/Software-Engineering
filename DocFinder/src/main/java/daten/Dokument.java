package daten;

import java.io.Serializable;

/**
 * Die Klasse "Dokument" repräsentiert ein Dokument mit Namen, Datentyp, Datum und Dateipfad.
 * Es kann auch ein zugehöriges Formular wiedergegeben und gesetzt werden.
 */
public class Dokument implements Serializable {
    private final String name;
    private final String datentyp;
    private final String datum;
    private final String dateipfad;

    private Formular formular;

    /**
     * Konstruktor der Dokument-Klasse.
     * Erzeugt ein Neues Dokument mit dem übergebenen Namen, Datentyp, Datum und Dateipfad.
     *
     * @param name       Der Name des Dokuments.
     * @param datentyp   Der Datentyp des Dokuments.
     * @param datum      Das Datum des Dokuments.
     * @param dateipfad  Der Dateipfad des Dokuments.
     */
    public Dokument(String name, String datentyp, String datum, String dateipfad) {
        this.name = name;
        this.datentyp = datentyp;
        this.datum = datum;
        this.dateipfad = dateipfad;
    }
    /**
     * Gibt den Namen des Dokuments zurück.
     *
     * @return Der Name des Dokuments.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt den Datentyp des Dokuments zurück.
     *
     * @return Der Datentyp des Dokuments.
     */
    public String getDatentyp() {
        return datentyp;
    }

    /**
     * Gibt das Datum des Dokuments zurück.
     *
     * @return Das Datum des Dokuments.
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Gibt den Dateipfad des Dokuments zurück.
     *
     * @return Der Dateipfad des Dokuments.
     */
    public String getDateipfad() {
        return dateipfad;
    }

    /**
     * Gibt das zugehörige Formular des Dokuments zurück.
     *
     * @return Das Formular des Dokuments.
     */
    public Formular getFormular() {
        return formular;
    }

    /**
     * Setzt das Formular für das Dokument mit den übergebenen Keywords, Bezeichnung und Wert gleich.
     *
     * @param keyword     Die Keywords für das Formular.
     * @param bezeichnung Die Bezeichnung des Formulars.
     * @param wert        Der Wert des Formulars.
     * @return Das Formular.
     */
    public Formular setFormular(String[] keyword, String bezeichnung, String wert) {
        formular = new Formular(keyword, bezeichnung, wert);
        return formular;
    }

    /**
     * ToString Methode, die den Namen, Datentyp, das Datum und den Dateipfad wiedergibt.
     *
     * @return den Namen, Datentyp, das Datum und den Dateipfad des Dokuments.
     */
    public String toString() {
        return name + ", " + datentyp + ", " + datum + ", " + dateipfad;
    }
}
