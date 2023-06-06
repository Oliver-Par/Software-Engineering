public class DatenVerwaltung implements SearchData{
    private Dokument[] documents;
    private Formular[] formulars;
    private Dokument dok;
    private Formular form;
    private Subscriber[] subscribers;
    private String[] data;
    public Dokument getDokument() {
        return dok;
    }

    public void setDokument(Dokument dokument) {
        this.dok = dokument;
    }

    public boolean saveData(Dokument[] dokuments) {
        return false;
    }

    public Dokument[] readData() {
        return new Dokument[0];
    }
}
