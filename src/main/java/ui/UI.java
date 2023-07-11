
package ui;

import daten.Dokument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI implements HandleUserEvent, Subscriber {
    private final String[] suchParameter = new String[5];
    system.EingabeVerarbeitung verarbeitung = new system.EingabeVerarbeitung();
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

    /**
     * Die Methode menueErstellen erstellt das UI-Menü für den User nachdem die Methode aufgerufen wird.
     * Nachdem das Menü angezeigt wurde, wird die Methode menueAuswahl aufgerufen um dann die Auswahl zu empfangen.
     */
    public void menueErstellen() {

        System.out.println("Wählen sie die 1 um ein daten.Dokument zu suchen!" + "\n" +
                "Wählen sie die 2 um ein daten.Dokument zu öffnen!" + "\n" +
                "Wählen sie die 3 um ein daten.Dokument zu speichern!" + "\n" +
                "Wählen sie die 4 um ein daten.Dokument zu löschen!" + "\n" +
                "Wählen sie die 5 um das Programm zu beenden!"
        );
        menueAuswahl();

    }

    /**
     * Die Methode menueAuswahl bekommt die Auswahl des Users als Eingabe übergeben und
     * fodert dann die nötigen Parameter, die für das ausführen der Aktion nötig sind.
     * Danach wird wieder vom System gefragt we
     * Wenn fünf eingegeben wird, wird das Programm beendet indem null returned wird.
     * @return null
     */
    public String menueAuswahl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie hier ein was sie machen möchten: ");
        String eingabe = sc.nextLine();

        List<daten.Dokument> dokuments = new ArrayList<daten.Dokument>();
        String pfad = "";


        while (!eingabe.equals("5")) {
            if (eingabe.equals("1")) {

                System.out.println("Geben Sie nun die Keywords ein, die das Dokument haben soll. Soll ein Feld leer bleiben, drücken Sie einfach die Enter-Taste.");
                List<Dokument> treffer = verarbeitung.suchergebnisAnzeigen(suchparameterEingabeOhneName());
                for (Dokument d : treffer) {
                    System.out.println(d);
                }
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
                keywords = suchparameterEingabe(name);

                System.out.println("Geben sie den Namen des Formulars ein: ");
                eingabe = sc.nextLine();
                bezeichnungFormular = eingabe;

                System.out.println("Geben sie das WertFormular ein: ");
                eingabe = sc.nextLine();
                wertFormular = eingabe;


                boolean erfolg = verarbeitung.dokumentHinzufuegenNachUser(name, datentyp, datum, dateipfad, keywords, bezeichnungFormular, wertFormular);
                if (erfolg) {
                    System.out.println("Das Anlegen war erfolgreich!");
                }
                System.out.println("Wählen sie die 1 um ein daten.Dokument zu suchen!" + "\n" +
                        "Wählen sie die 2 um ein daten.Dokument zu öffnen!" + "\n" +
                        "Wählen sie die 3 um ein daten.Dokument zu speichern!" + "\n" +
                        "Wählen sie die 4 um ein daten.Dokument zu löschen!" + "\n" +
                        "Wählen sie die 5 um das Programm zu beenden!"
                );
                eingabe = sc.nextLine();
            } else {
                System.out.println("Bitte überprüfen sie die Eingabe");

                System.out.println("Wählen sie die 1 um ein daten.Dokument zu suchen!" + "\n" +
                        "Wählen sie die 2 um ein daten.Dokument zu öffnen!" + "\n" +
                        "Wählen sie die 3 um ein daten.Dokument zu speichern!" + "\n" +
                        "Wählen sie die 4 um ein daten.Dokument zu löschen!" + "\n" +
                        "Wählen sie die 5 um das Programm zu beenden!"
                );
                eingabe = sc.nextLine();

            }
        }
        return null;
    }

    /**
     * Die Methode erwartet vom Benutzer fünf Eingaben die vom System Kategorisiert abgefragt werden.
     * Die von User übergebenen Suchparamter werden anschließend in ein Suchparameter Array gespeichert.
     * @param name
     * @return String[] suchParamter
     */
    public String[] suchparameterEingabe(String name) {
        Scanner sc = new Scanner(System.in);
        String eingabe = "";

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                suchParameter[i] = name;
            }
            if (i == 1) {
                System.out.println("Art des Dokuments: ");
            }
            if (i == 2) {
                System.out.println("Namen des Arztes: ");
            }
            if (i == 3) {
                System.out.println("Datum der Untersuchung: ");
            }
            if (i == 4) {
                System.out.println("Ort der Untersuchung: ");
            }
            if (i != 0) {
                eingabe = sc.nextLine();
                suchParameter[i] = eingabe;
            }

        }
        System.out.println("Die Suchparameterabfrage ist nun abgeschlossen!" + "\n");
        return suchParameter;
    }
    /**
     * Die Methode erwartet vom Benutzer fünf Eingaben die vom System Kategorisiert abgefragt werden.
     * Die von User übergebenen Suchparamter werden anschließend in ein Suchparameter Array gespeichert.
     * @return String[] suchParamter
     */
    public String[] suchparameterEingabeOhneName() {
        Scanner sc = new Scanner(System.in);
        String eingabe = "";

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.println("Namen des Dokuments: ");
            }
            if (i == 1) {
                System.out.println("Art des Dokuments: ");
            }
            if (i == 2) {
                System.out.println("Namen des Arztes: ");
            }
            if (i == 3) {
                System.out.println("Datum der Untersuchung: ");
            }
            if (i == 4) {
                System.out.println("Ort der Untersuchung: ");
            }
            eingabe = sc.nextLine();
            suchParameter[i] = eingabe;
        }
        System.out.println("Die Suchparameterabfrage ist nun abgeschlossen!" + "\n");
        return suchParameter;
    }

    public void update(String[] ausgabe) {

    }
}
