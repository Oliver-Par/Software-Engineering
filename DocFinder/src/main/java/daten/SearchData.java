package daten;

import java.util.List;

public interface SearchData {
    List<Dokument> getDokument();

    void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert);

    boolean saveData(Dokument[] dokuments);

    List<Dokument> readData();



}