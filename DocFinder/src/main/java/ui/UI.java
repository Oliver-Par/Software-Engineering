package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UI implements HandleUserEvent, Subscriber {
    private String[] suchParameter = new String[5];

    private String[] ausgabe;

    private String name;
    private String datentyp;
    private String datum;
    private String dateipfad;
    private String[] keywords;
    private String keyword;
    private String bezeichnungFormular;
    private String wertFormular;

    public UI() {

    }

    public void menueErstellen() {

        System.out.println("Wählen sie die 1 um ein daten.Dokument zu suchen!" + "\n" +
                "Wählen sie die 2 um ein daten.Dokument zu öffnen!" + "\n" +
                "Wählen sie die 3 um ein daten.Dokument zu speichern!" + "\n" +
                "Wählen sie die 4 um ein daten.Dokument zu löschen!" + "\n" +
                "Wählen sie die 5 um das Programm zu beenden!"
        );
        menueAuswahl();

    }

    public String menueAuswahl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie hier ein was sie machen möchten: ");
        String eingabe = sc.nextLine();

        List<daten.Dokument> dokuments = new ArrayList<daten.Dokument>();
        String pfad = "";



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
                System.out.println("Geben sie den Namen vom daten.Dokument ein: ");
                eingabe = sc.nextLine();
                name = eingabe;

                String[] temp = name.split("\\.");
                datentyp = temp[temp.length - 1];

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
                LocalDate localDate = LocalDate.now();
                datum = localDate.toString();

                System.out.println("Geben sie den Dateipfad ein: ");
                eingabe = sc.nextLine();
                dateipfad = eingabe;

                System.out.println("Geben Sie jetzt die vom System angefragten Suchparameter ein: ");
                suchparameterEingabe();

                System.out.println("Geben sie den BezeichnungFormular ein: ");
                eingabe = sc.nextLine();
                bezeichnungFormular = eingabe;

                System.out.println("Geben sie das WertFormular ein: ");
                eingabe = sc.nextLine();
                wertFormular = eingabe;

                system.EingabeVerarbeitung verarbeitung = new system.EingabeVerarbeitung(pfad);
                verarbeitung.dokumentHinzufuegenNachUser(name, datentyp, datum, dateipfad, keywords, bezeichnungFormular, wertFormular);

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

    public String[] suchparameterEingabe() {
        Scanner sc = new Scanner(System.in);
        String eingabe = "";

        for (int i = 0; i<5;i++){
            if (i==0){
                System.out.println("Namen des Dokuments: ");
            }
            if (i==1){
                System.out.println("Art des Dokuments: ");
            }
            if (i==2){
                System.out.println("Namen des Arztes: ");
            }
            if (i==3){
                System.out.println("Datum der Untersuchung: ");
            }
            if (i==4){
                System.out.println("Ort der Untersuchung: ");
            }
            eingabe = sc.nextLine();
            suchParameter[i] = eingabe;

        }
        return suchParameter;
    }

    public void update(String[] ausgabe) {

    }
}