public interface SearchData {
    Dokument getDokument();

    void setDokument(Dokument dokument);

    boolean saveData(Dokument[] dokuments);

    Dokument[] readData();



}
