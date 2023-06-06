public interface SearchData {
    Dokument getDokument();

    void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert);

    boolean saveData(Dokument[] dokuments);

    Dokument[] readData();



}
