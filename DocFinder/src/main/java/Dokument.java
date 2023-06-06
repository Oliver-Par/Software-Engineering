public class Dokument{
    private String name;
    private String datentyp;
    private String datum;
    private String dateipfad;

    //Aus Node
    private Dokument dokument;

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

    public void setFormular(String[] keyword, String bezeichnung, String wert) {
        this.formular = new Formular(keyword, bezeichnung, wert);
    }
}
