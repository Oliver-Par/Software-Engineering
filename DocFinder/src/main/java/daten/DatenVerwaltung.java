package daten;

import ui.Subscriber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatenVerwaltung implements SearchData, Serializable {
    private final List<Formular> formulars;
    private List<Dokument> documents;
    private Dokument dok;
    private Formular form;
    private Subscriber[] subscribers;
    private String[] data;

    public DatenVerwaltung(List<Dokument> dokuments, String[][] keywords, String[] bezeichnung, String[] wert) {
        if (dokuments != null) {
            documents = dokuments;
            formulars = new ArrayList<>();
            int n = -1;
            for (Dokument d : dokuments) {
                n++;
                form = d.setFormular(keywords[n], bezeichnung[n], wert[n]);
                formulars.add(form);
            }
            n = -1;
        } else {
            documents = new ArrayList<>();
            formulars = new ArrayList<>();
        }
    }

    public List<Dokument> getDokument() {
        return documents;
    }

    public void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert) {
        try {
            form = dokument.setFormular(keywords, bezeichnung, wert);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            throw new NullPointerException("Dokument, das versucht wird zu setzen ist null.");
        }
        dok = dokument;
        addDokument(dok);
        addFormular(form);
    }

    private void addDokument(Dokument dokument) {
        documents.add(dokument);
    }

    private void addFormular(Formular formular) {
        formulars.add(formular);
    }

    public boolean saveData() {
        List<Dokument> tempList = documents;
        documents = readData();
        for (Dokument doc : tempList) {
            documents.add(doc);
        }
        try (FileOutputStream fos = new FileOutputStream("save.txt")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                for (Dokument d : documents) {
                    try {
                        oos.writeObject(d);
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                        System.out.println("File does not allow to be interacted with.");
                        return false;
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("File does not allow to be interacted with. Or ObjectOutputStream may not be able to be closed.");
                return false;
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("A File was not found, new Filepath needs to be given.");
            return false;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("FileOutputStream can not be closed.");
            return false;
        }
        return true;
    }

    public List<Dokument> readData() {
        List<Dokument> dokList = new ArrayList<>();

        Dokument test;
        try (FileInputStream fis = new FileInputStream("save.txt")) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                try {
                    while ((test = (Dokument) ois.readObject()) != null) {
                        dokList.add(test);
                    }
                } catch (ClassNotFoundException cnfe) {
                    cnfe.printStackTrace();
                    System.out.println("Class of an serialized object cannot be found.");
                }
            } catch (EOFException eofe) {
                //Der Reader hat das Ende erreicht und wird geschlossen.
            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("ObjectOutputStream can not be closed.");
            }
        } /*catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("A File was not found, new Filepath needs to be given.");
        } */ catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("FileOutputStream can not be closed.");
        }
        return dokList;
    }

    public int hashCode() {
        int result = 1;
        for (Dokument d : documents) {
            result = 31 * result + (d != null ? d.hashCode() : 0);
        }
        return result;
    }
}