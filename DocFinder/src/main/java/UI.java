import java.util.*;

public class UI implements HandleUserEvent, Subscriber{
    private String[] suchParameter;

    private String[] ausgabe;

    private String name;
    private String datentyp;
    private String datum;
    private String dateipfad;

    public UI(){

    }

    public void menueErstellen(){

        System.out.println("Wählen sie die 1 um ein Dokument zu suchen!" + "\n" +
                           "Wählen sie die 2 um ein Dokument zu öffnen!" + "\n" +
                           "Wählen sie die 3 um ein Dokument zu speichern!" + "\n" +
                           "Wählen sie die 4 um ein Dokument zu löschen!" + "\n" +
                           "Wählen sie die 5 um das Programm zu beenden!"
                            );
        menueAuswahl();

    }

    public String menueAuswahl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie hier ein was sie machen möchten: ");
        String eingabe = sc.nextLine();

        List<Dokument> dokuments = new List<Dokument>();
        String pfad = "";
        EingabeVerarbeitung verarbeitung = new EingabeVerarbeitung();


        while (!eingabe.equals("5")) {
            if (eingabe.equals("1")) {

                System.out.println("Geben sie hier ein ob sie eine Adresse laden wollen, eine Speizielle suchen, eine neue Speichern möchte oder ob sie das Programm beenden wollen");
                eingabe = sc.nextLine();
            }
            if (eingabe.equals("2")) {
                System.out.println("Bitte suchbegriff angeben");
                eingabe = sc.nextLine();

                System.out.println("Geben sie hier ein ob sie eine Adresse laden wollen, eine Speizielle suchen, eine neue Speichern möchte oder ob sie das Programm beenden wollen");
                eingabe = sc.nextLine();
            }
            if (eingabe.equals("3")) {
                System.out.println("Geben sie den Namen vom Dokument ein");
                eingabe = sc.nextLine();
                name=eingabe;
                System.out.println("Geben sie den Dateityp ein");
                eingabe = sc.nextLine();
                datentyp =eingabe;
                System.out.println("Geben sie das Erstellungsdatum ein");
                eingabe = sc.nextLine();
                datum= eingabe;
                System.out.println("Geben sie den Dateipfad ein");
                eingabe = sc.nextLine();
                dateipfad = eingabe;

                verarbeitung.DokumentHinzufuegenNachUser(name, datentyp, datum, dateipfad);

                System.out.println("Geben sie hier ein ob sie eine Adresse laden wollen, eine Speizielle suchen, eine neue Speichern möchte oder ob sie das Programm beenden wollen");
                eingabe = sc.nextLine();
            } else {
                System.out.println("Bitte überprüfen sie die Eingabe");

                System.out.println("Geben sie hier ein ob sie eine Adresse laden wollen, eine Speizielle suchen, eine neue Speichern möchte oder ob sie das Programm beenden wollen");
                eingabe = sc.nextLine();

            }
        }
        return null;
    }
    public String[] suchparameterEingabe(){
        return suchParameter;
    }

    public void update(String[] ausgabe){}
}
