package assignments.no5.testare;

import assignments.no5.exceptii.ValoriInvalideProdusException;
import assignments.no5.exceptii.ValoriLipsaProdusException;
import assignments.no5.model.Produs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProdusCerinta2Test {
    public static Produs produs;
    public static Produs produsCuVanzari;
    public static String numeInitial = "AsusUX43";
    public static float pretInitial = 499.98F;
    public static ArrayList<Integer> produseVanduteSaptamanal = new ArrayList<>();

    @Before
    public void setUp() throws ValoriInvalideProdusException {
        produseVanduteSaptamanal = new ArrayList<>() {
            {
                add(350);
                add(450);
                add(376);
            }
        };
        produs = new Produs(numeInitial, pretInitial);
        produsCuVanzari = new Produs(numeInitial, pretInitial, produseVanduteSaptamanal);
    }

    @After
    public void tearDown() throws Exception {
        produseVanduteSaptamanal.clear();
        produseVanduteSaptamanal = null;
        produs = null;
        produsCuVanzari = null;
    }
//    adaugaSaptamana()
//    getNrProduseVandute()
//    getNrSaptamaniPesteMedie()

    //    1 test Right pentru fiecare metodă;
    @Test
    public void adaugaSaptamanaValoareCorectaTest() throws ValoriInvalideProdusException {
        int valoareaAsteptata = Produs.MAX_PRODUSE_VANDUTE_SAPTAMANA - 159;
        produsCuVanzari.adaugaSaptamana(valoareaAsteptata);
        int valoareActuala = produsCuVanzari.getProduseVanduteSaptamanal()
                .get(produsCuVanzari.getProduseVanduteSaptamanal().size() - 1);
        assertEquals("Valoarea nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void getNrProduseVanduteValoareCorectaTest() throws ValoriInvalideProdusException, ValoriLipsaProdusException {
        int valoareaAsteptata = Produs.MAX_PRODUSE_VANDUTE_SAPTAMANA - 159;
        produsCuVanzari.adaugaSaptamana(valoareaAsteptata);
        int valoareActuala = produsCuVanzari
                .getNrProduseVandute(produsCuVanzari.getProduseVanduteSaptamanal().size() - 1);
        assertEquals("Valoarea nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void getNrSaptamaniPesteMedieValoareCorectaTest()
            throws ValoriInvalideProdusException, ValoriLipsaProdusException {
        produsCuVanzari.adaugaSaptamana(500);
        produsCuVanzari.adaugaSaptamana(679);
        produsCuVanzari.adaugaSaptamana(998);
        int valoareAsteptata = 3;
        int nrSaptamaniPesteMedie = produsCuVanzari.getNrSaptamaniPesteMedie(500);
        assertEquals(valoareAsteptata, nrSaptamaniPesteMedie);

    }

    //    1 test Range pentru a verifica o condiție pentru care funcția testată generează o excepție (pentru fiecare metodă);
    @Test(expected = ValoriInvalideProdusException.class)
    public void adaugaSaptamanaRangeMinimTest() throws ValoriInvalideProdusException {
        produsCuVanzari.adaugaSaptamana(Integer.MIN_VALUE);
    }

//    2 teste pentru verificarea limitelor extreme (Boundary) pentru fiecare metodă;


//    2 teste de Cardinalitate pentru getNrSaptamaniPesteMedie();

//    2 teste de tip Ordering pentru getNrSaptamaniPesteMedie();

//    numai pentru getNrSaptamaniPesteMedie() un test de performanță / timp care va verifica dacă funcția returnează un rezultat sub 3 secunde pentru o lista cu 1000 de săptămâni

//    2 teste la alegere pentru a verifica alte criterii (altele decât cele de mai sus) pentru orice metodă.

}
