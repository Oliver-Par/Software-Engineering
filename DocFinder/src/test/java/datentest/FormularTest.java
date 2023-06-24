package datentest;

import daten.Formular;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FormularTest {
    @Test
    public void testeGetWert(){
        String[] keyword = new String[]{"Blutbild","Allgemeines Krankenhaus","21.11.2022"};
        Formular test = new Formular(keyword,"Blutbild", "5");
        Assertions.assertEquals("5",test.getWert());
    }
    @Test
    public void testeGetKeyword(){
        String[] keyword = new String[]{"Blutbild","Allgemeines Krankenhaus","21.11.2022"};
        Formular test = new Formular(keyword,"Blutbild", "5");
        Assertions.assertArrayEquals(keyword,test.getKeyword());
    }
    @Test
    public void testeGetBezeichnung(){
        String[] keyword = new String[]{"Blutbild","Allgemeines Krankenhaus","21.11.2022"};
        Formular test = new Formular(keyword,"Blutbild", "5");
        Assertions.assertEquals("Blutbild", test.getBezeichnung());
    }

}
