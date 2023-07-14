package ui;


import daten.DatenVerwaltung;

public class Main {
    public static void main(String[] args){
        DatenVerwaltung.initDB();
        UI ui = new UI();
        ui.menueErstellen();
    }
}
