package ui;


import daten.DatenVerwaltung;

public class Main {
    public static void main(String[] args){
        //DatenVerwaltung.initDB();  --erstellt nur eine neue leere Datei bei jedem Start, welche auch nie benutzt wird und bei jedem Re-Run einen Bug auslöst!
        UI ui = new UI();
        ui.menueErstellen();
    }
}
