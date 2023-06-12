package daten;

public class Formular {
    private String[] keyword;

    private String bezeichnung;

    private String wert;

    public Formular(String[] keyword, String bezeichnung, String wert){
        this.keyword = keyword;
        this.bezeichnung = bezeichnung;
        this.wert = wert;
    }

    public String[] getKeyword(){
        return this.keyword;
    }

    public String getBezeichnung(){
        return this.bezeichnung;
    }

    public String getWert(){
        return this.wert;
    }
}
