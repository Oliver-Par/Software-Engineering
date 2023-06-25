package daten;

import java.io.Serializable;

public class Formular implements Serializable {
    private String[] keyword;

    private String bezeichnung;

    private String wert;

    /**
     * Der Konstruktor vom Formular erzeugt ein neues Formular mit den übergebenen Parametern
     * keywords, bezeichnung und wert.
     * @param keyword
     * @param bezeichnung
     * @param wert
     */
    public Formular(String[] keyword, String bezeichnung, String wert){
        this.keyword = keyword;
        this.bezeichnung = bezeichnung;
        this.wert = wert;
    }

    /**
     * Die Methode gibt das Array von keywords von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return keywords
     */
    public String[] getKeyword(){
        return this.keyword;
    }
    /**
     * Die Methode gibt die bezeichnung von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return bezeichnung
     */
    public String getBezeichnung(){
        return this.bezeichnung;
    }
    /**
     * Die Methode gibt den wert von dem Formular, auf dem die Methode aufgerufen wird, zurürck.
     * @return wert
     */

    public String getWert(){
        return this.wert;
    }
}
