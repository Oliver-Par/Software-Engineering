package daten;

import java.io.Serializable;

public class Formular implements Serializable {
    private String[] keyword;

    private String bezeichnung;

    private String wert;

    /**
     * Der Konstruktor vom Formular erzeugt ein neues Formular mit den übergebenen Parametern
     * keywords, bezeichnung und wert.
     * @param keyword die Keywords des Formulares.
     * @param bezeichnung die Bezeichnung des Formulares.
     * @param wert der Wert des Formulares
     */
    public Formular(String[] keyword, String bezeichnung, String wert){
        this.keyword = keyword;
        this.bezeichnung = bezeichnung;
        this.wert = wert;
    }

    /**
     * Die Methode gibt das Array von keywords von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return Die keywords des Fomulares
     */
    public String[] getKeyword(){
        return this.keyword;
    }
    /**
     * Die Methode gibt die bezeichnung von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return die Bezeichnung des Formulares.
     */
    public String getBezeichnung(){
        return this.bezeichnung;
    }
    /**
     * Die Methode gibt den wert von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return Der Wert des Formulares.
     */

    public String getWert(){
        return this.wert;
    }
}
