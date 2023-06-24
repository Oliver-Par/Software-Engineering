package daten;

import java.util.List;

public interface SearchData {
    List<Dokument> getDokument();

    boolean saveData();

    void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert); //Nur Interface

    List<Dokument> readData();


}