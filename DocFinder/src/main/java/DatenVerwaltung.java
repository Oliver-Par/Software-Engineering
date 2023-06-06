import java.io.*;

public class DatenVerwaltung implements SearchData{
    private Dokument[] documents;
    private Formular[] formulars;
    private int size;
    private Dokument dok;
    private Formular form;
    private Subscriber[] subscribers;
    private String[] data;

    public DatenVerwaltung(int size){
        this.size = size;
    }
    public Dokument getDokument() {
        return dok;
    }

    public void setDokument(Dokument dokument, String[] keywords, String bezeichnung, String wert) {
        dokument.setFormular(keywords, bezeichnung, wert);
        this.dok = dokument;
        addDokument(dok);
    }

    private void addDokument(Dokument dokument){
        if (size == documents.length) {
            Dokument[] newDokuments = new Dokument[documents.length*2];
            System.arraycopy(documents, 0, newDokuments, 0, size);
            documents = newDokuments;
        }
        documents[size] =dokument;
        size++;
    }

    public boolean saveData(Dokument[] dokuments) {
        try(PrintWriter out = new PrintWriter("DocFinder/src/main/save.txt")) {
            for (Dokument d: dokuments) {
                out.println(d);
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            System.out.println("A File was not found, new Filepath needs to be given.");
            return false;
        }
        return true;
    }

    public Dokument[] readData() {
        try{
            FileInputStream inputStream = new FileInputStream("DocFinder/src/main/save.txt");
            InputStream i = inputStream;
            BufferedReader in = new BufferedReader(new InputStreamReader(i));

            Dokument dok;
            int n = 0;
            try {
                while ((dok = in.readLine()) != null) {
                    this.documents[n] = dok;
                    n++;
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
                System.out.println("The File does not have ");
            }
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
            System.out.println("A File was not found, new Filepath needs to be given.");
            return false;
            }
        }
    }
}
