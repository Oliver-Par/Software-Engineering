package daten;

import ui.Subscriber;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class DatenVerwaltung implements SearchData, Serializable {
    private final List<Formular> formulars;
    private final List<Dokument> documents;
    private Dokument dok;
    private Formular form;
    private Subscriber[] subscribers;
    private String[] data;

    /**
     * Konstruktor der DatenVerwaltung-Klasse.
     * Erzeugt eine neue Datenverwaltung mit den übergebenen Dokumenten, Keywords, Bezeichnungen und Werten, welche als Formular zusammengefasst werden.
     *
     * @param dokuments   Die Liste der Dokumente.
     * @param keywords    Ein Array der Keywords für jedes Dokument vorgibt.
     * @param bezeichnung Ein Array der Bezeichnungen für die Formulare vorgibt.
     * @param wert        Ein Array der Werte für die Formulare vorgibt.
     */
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
            documents = readData();
            boolean notNull = false;
            ArrayList<Formular> tempList = new ArrayList<>();
            try {
                for (Dokument d : documents) {
                    tempList.add(d.getFormular());
                    notNull = true;
                }
            } catch (NullPointerException epe) {

            }
            formulars = tempList;
        }
    }

    public DatenVerwaltung() {
        documents = new ArrayList<>();
        formulars = new ArrayList<>();
    }

    public static void initDB() {
        try {
            Files.createDirectories(Paths.get(DatenVerwaltung.getDBPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.createFile(Paths.get(DatenVerwaltung.getDBFilePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDBPath() throws IOException {
        return new File(".").getCanonicalPath() + "\\data";
    }

    public static String getDBFilePath() throws IOException {
        return DatenVerwaltung.getDBPath() + "\\" + "save.txt";
    }

    /**
     * Gibt die Liste der Dokumente zurück.
     *
     * @return Die Liste der Dokumente.
     */
    public List<Dokument> getDokument() {
        return documents;
    }

    /**
     * Setzt das Formular für das angegebene Dokument mit den übergebenen Keywords, Bezeichnung und Wert gleich.
     * Fügt das Dokument und das Formular hinzu.
     *
     * @param dokument    Das Dokument, für das das Formular gesetzt werden soll.
     * @param keywords    Die Keywords für das Formular.
     * @param bezeichnung Die Bezeichnung des Formulars.
     * @param wert        Der Wert des Formulars.
     */
    public void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert) {
        form = dokument.setFormular(keywords, bezeichnung, wert);
        dok = dokument;
        addDokument(dok);
        addFormular(form);
    }

    /**
     * Löscht das angegebene Dokument aus der Liste der Dokumente.
     *
     * @param zuLoeschendesDokument Das zu löschende Dokument
     */
    public void deleteDokument(Dokument zuLoeschendesDokument) {
        for (int i = 0; i < documents.size(); i++) {
            if (documents.get(i).getName().equals(zuLoeschendesDokument.getName())
                    && documents.get(i).getDatentyp().equals(zuLoeschendesDokument.getDatentyp())) {
                documents.remove(i);
            }
        }

    }

    /**
     * Fügt das Dokument der Fomularliste hinzu.
     *
     * @param dokument Das Dokument, welches hinzugefügt werden soll.
     */
    private void addDokument(Dokument dokument) {
        documents.add(dokument);
    }

    /**
     * Fügt das Formular der Fomularliste hinzu.
     *
     * @param formular Das Formular, welches hinzugefügt werden soll.
     */
    private void addFormular(Formular formular) {
        formulars.add(formular);
    }

    /**
     * Speichert die Daten der Datenverwaltung in einer serialisierten Datei.
     *
     * @return true wenn das Speichern erfolgreich war, sonst false.
     */
    public boolean saveData() {
        /*List<Dokument> bereitsGespeichert = readData();
        for (Dokument d : bereitsGespeichert) {
            if (!documents.contains(d.getFormular().getKeyword())) {
                setDokument(d, d.getFormular().getKeyword(), d.getFormular().getBezeichnung(), d.getFormular().getWert());
            }
        }*/
        try (FileOutputStream fos = new FileOutputStream("src/main/save.txt")) {
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
 /*   public boolean deleteData() {
        List<Dokument> tempList = this.documents;
        this.documents = this.readData();
        for (Dokument doc : tempList) {
            documents.remove(doc);
        }


        try {
            FileOutputStream fos = new FileOutputStream("save.txt");

            try {
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (Dokument d : this.documents) {
                    try {
                        oos.writeObject(d);
                    } catch (IOException var10) {
                        var10.printStackTrace();
                        System.out.println("File does not allow to be interacted with.");
                        return false;
                    }
                }

                oos.close();
            } catch (IOException var11) {
                var11.printStackTrace();
                System.out.println("File does not allow to be interacted with. Or ObjectOutputStream may not be able to be closed.");
                return false;
            } finally {
                try {
                    fos.close();
                } catch (IOException var12) {
                    var12.printStackTrace();
                    System.out.println("FileOutputStream can not be closed.");
                }
            }

            return true;
        } catch (FileNotFoundException var13) {
            var13.printStackTrace();
            System.out.println("A File was not found, new Filepath needs to be given.");
            return false;
        }
    } */

    /**
     * Liest die Daten der Dokumente und Fomulare aus einer Datei.
     *
     * @return Liste der gelesenen Dokumente.
     */
    public List<Dokument> readData() {
        List<Dokument> dokList = new ArrayList<>();

        Dokument test;

        // mit getDBFilePath hat es nicht funktioniert!
        // Hier muss src/main/save.txt als Pfad gesetzt sein (wie bei saveData())
        try (FileInputStream fis = new FileInputStream("src/main/save.txt")) {
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