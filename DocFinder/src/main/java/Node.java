public class Node<Dokument, Formular> implements SearchData{
    private Dokument dokument;

    private Formular[] formular;

    public Node(Dokument dokument, Formular[] formular){
        this.dokument = dokument;
        this.formular = formular;
    }

    public Dokument getDokument() {
        return this.dokument;
    }

    public Formular getFormular() {
        return (Formular) this.formular;
    }

    public void setFormular(Formular formular) {

    }

    public void setDokument(Dokument dokument) {

    }
}
