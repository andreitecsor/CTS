package assignments.no5.testare;

import assignments.no5.exceptii.ValoriInvalideProdusException;
import assignments.no5.exceptii.ValoriLipsaProdusException;
import assignments.no5.model.Produs;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ProdusCerinta3Test {
    public static Produs produs;
    public static Produs produsCuVanzari;
    public static String numeInitial = "AsusUX43";
    public static float pretInitial = 499.98F;
    public static ArrayList<Integer> produseVanduteSaptamanal = new ArrayList<>();
    public static ArrayList<Integer> produseVanduteSaptamanalPerfomanta = new ArrayList<>();

    @BeforeClass
    public static void setUpBeforeClass() {
        for (int i = 0; i < 1000; i++) {
            produseVanduteSaptamanalPerfomanta.add(Produs.MAX_PRODUSE_VANDUTE_SAPTAMANA);
        }
    }

    @Before
    public void setUp() throws ValoriInvalideProdusException {
        produseVanduteSaptamanal = new ArrayList<>() {
            {
                add(500);
                add(869);
                add(420);
                add(701);
            }
        };
        produs = new Produs(numeInitial, pretInitial);
        produsCuVanzari = new Produs(numeInitial, pretInitial, produseVanduteSaptamanal);
    }

    @After
    public void tearDown() {
        produseVanduteSaptamanal.clear();
        produseVanduteSaptamanal = null;
        produs = null;
        produsCuVanzari = null;
    }

    //    1 test Right pentru fiecare metodă;
    @Test
    public void getProcentSaptamaniSlabeValoriCorecteTest() throws ValoriLipsaProdusException {
        float valoareActuala = produsCuVanzari.getProcentSaptamaniSlabe(501);
        float valoareAsteptata = 50.0f;
        assertEquals(valoareAsteptata, valoareActuala, 0);
    }

    @Test
    public void getIndexSaptamaniCuVanzariMaximeValoriCorecteTest()
            throws ValoriLipsaProdusException, ValoriInvalideProdusException {
        produsCuVanzari.adaugaSaptamana(869);
        ArrayList<Integer> valoareActuala = produsCuVanzari.getIndexSaptamaniCuVanzariMaxime();
        List<Integer> valoareAsteptata = Arrays.asList(1, 4);
        assertEquals(valoareAsteptata, valoareActuala);
    }

    //    1 test de tip Cross-Check;
    @Test
    public void getProcentSaptamaniSlabeCrossCheckTest() throws ValoriLipsaProdusException {
        float procentSaptamaniSlabe = produsCuVanzari.getProcentSaptamaniSlabe(501);
        float nrSaptamaniPesteMedie = produsCuVanzari.getNrSaptamaniPesteMedie(501);
        float nrTotalSaptamani = this.produsCuVanzari.getProduseVanduteSaptamanal().size();
        float procentSaptamaniSlabeCalculatAltfel = 100 * ((nrTotalSaptamani - nrSaptamaniPesteMedie) / nrTotalSaptamani);
        assertEquals(procentSaptamaniSlabeCalculatAltfel, procentSaptamaniSlabe, 0);
    }

    //    1 test de tip Inverse Relationship;
    @Test
    public void getIndexSaptamaniCuVanzariMaximeInverseRelationshipTest()
            throws ValoriLipsaProdusException, ValoriInvalideProdusException {
        produsCuVanzari.adaugaSaptamana(869);
        ArrayList<Integer> listaIndexSaptamaniMax = produsCuVanzari.getIndexSaptamaniCuVanzariMaxime();
        ArrayList<Integer> produseVanduteSaptamanal = produsCuVanzari.getProduseVanduteSaptamanal();

        for (int indexSaptamana = 0; indexSaptamana < produseVanduteSaptamanal.size(); indexSaptamana++) {
            if(produseVanduteSaptamanal.get(indexSaptamana) > Collections.max(produseVanduteSaptamanal)) {
                if (!listaIndexSaptamaniMax.contains(indexSaptamana)) {
                    fail("Nu contine aceleasi valori");
                }
            }
        }

        assertTrue(true);
    }

    //    2 teste la alegere pentru a verifica alte criterii (altele decât cele de mai sus) pentru oricare dintre cele 2 metode.
    @Test(timeout = 1000)
    public void getProcentSaptamaniSlabePerformanceTest() throws ValoriLipsaProdusException {
        float valoareActuala = produsCuVanzari.getProcentSaptamaniSlabe(501);
        float valoareAsteptata = 50.0f;
        assertEquals(valoareAsteptata, valoareActuala, 0);
    }

    @Category(ErrorConditionTests.class)
    @Test(expected = ValoriLipsaProdusException.class)
    public void getProcentSaptamaniSlabeErrorConditionTest() throws ValoriLipsaProdusException {
        produs.getProcentSaptamaniSlabe(501);
    }

}
