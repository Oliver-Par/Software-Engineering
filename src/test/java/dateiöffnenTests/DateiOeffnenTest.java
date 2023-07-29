package dateiöffnenTests;

import org.junit.jupiter.api.Test;
import system.EingabeVerarbeitung;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateiOeffnenTest {
    @Test
    public void testDateiOeffnen(){
        EingabeVerarbeitung verarbeitung = new EingabeVerarbeitung();
        assertEquals(verarbeitung.dateiOeffnen("null.pdf"), true);



    }
}