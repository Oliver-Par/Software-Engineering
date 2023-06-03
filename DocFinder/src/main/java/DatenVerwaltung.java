public class DatenVerwaltung implements SearchData{
    private Dokument[] documents;
    private Formular[] formulars;
    private Dokument dok;
    private Formular form;
    private Subscriber[] subscribers;
    private String[] data;
    public Dokument getDokument() {
        return null;
    }

    public void setDokument(Dokument dokument) {

    }

    public boolean saveData(Dokument[] dokuments) {
        return false;
    }

    public Dokument[] readData() {
        return new Dokument[0];
    }

    public Formular getFormular() {
        return null;
    }

    public void setFormular(Formular formular) {

    }
}
