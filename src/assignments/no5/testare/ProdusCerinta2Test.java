package assignments.no5.testare;

import assignments.no5.exceptii.ValoriInvalideProdusException;
import assignments.no5.exceptii.ValoriLipsaProdusException;
import assignments.no5.model.Produs;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProdusCerinta2Test {
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
    @Test
    public void adaugaSaptamanaBoundaryMinimTest() throws ValoriInvalideProdusException {
        int valoareaAsteptata = Produs.MIN_PRODUSE_VANDUTE_SAPTAMANA;
        produsCuVanzari.adaugaSaptamana(valoareaAsteptata);
        int valoareActuala = produsCuVanzari.getProduseVanduteSaptamanal()
                .get(produsCuVanzari.getProduseVanduteSaptamanal().size() - 1);
        assertEquals("Valoarea minima nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void adaugaSaptamanaBoundaryMaximTest() throws ValoriInvalideProdusException {
        int valoareaAsteptata = Produs.MAX_PRODUSE_VANDUTE_SAPTAMANA;
        produsCuVanzari.adaugaSaptamana(valoareaAsteptata);
        int valoareActuala = produsCuVanzari.getProduseVanduteSaptamanal()
                .get(produsCuVanzari.getProduseVanduteSaptamanal().size() - 1);
        assertEquals("Valoarea maxima nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void getNrProduseVanduteBoundaryMinimTest() throws ValoriLipsaProdusException {
        int INDEX_MINIM_SAPTAMANI = 0;
        int valoareaAsteptata = produseVanduteSaptamanal.get(INDEX_MINIM_SAPTAMANI);
        int valoareActuala = produsCuVanzari.getNrProduseVandute(INDEX_MINIM_SAPTAMANI);
        assertEquals("Valoarea nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void getNrProduseVanduteBoundaryMaximTest() throws ValoriLipsaProdusException {
        int INDEX_MAXIM_SAPTAMANI = produseVanduteSaptamanal.size() - 1;
        int valoareaAsteptata = produseVanduteSaptamanal.get(INDEX_MAXIM_SAPTAMANI);
        int valoareActuala = produsCuVanzari.getNrProduseVandute(INDEX_MAXIM_SAPTAMANI);
        assertEquals("Valoarea nu a fost adaugata corect", valoareaAsteptata, valoareActuala);
    }

    @Test
    public void getNrSaptamaniPesteMedieBoundaryMinimTest()
            throws ValoriLipsaProdusException {
        int valoareAsteptata = produsCuVanzari.getProduseVanduteSaptamanal().size();
        int nrSaptamaniPesteMedie = produsCuVanzari.getNrSaptamaniPesteMedie(Produs.MIN_PRODUSE_VANDUTE_SAPTAMANA);
        assertEquals(valoareAsteptata, nrSaptamaniPesteMedie);
    }

    @Test
    public void getNrSaptamaniPesteMedieBoundaryMaximTest()
            throws ValoriLipsaProdusException {
        int valoareAsteptata = 0;
        int nrSaptamaniPesteMedie = produsCuVanzari.getNrSaptamaniPesteMedie(Produs.MAX_PRODUSE_VANDUTE_SAPTAMANA);
        assertEquals(valoareAsteptata, nrSaptamaniPesteMedie);
    }

    //2 teste de Cardinalitate pentru getNrSaptamaniPesteMedie();
    @Test(expected = ValoriLipsaProdusException.class)
    public void getNrSaptamaniPesteMedieCardinalityZeroTest()
            throws ValoriInvalideProdusException, ValoriLipsaProdusException {
        ArrayList<Integer> produseVanduteSaptamanalCardinality = new ArrayList<>();
        produs.setVanzari(produseVanduteSaptamanalCardinality);
        produs.getNrSaptamaniPesteMedie(Produs.MIN_PRODUSE_VANDUTE_SAPTAMANA);
        fail("Trebuia sa primim exceptia cum ca nu se poate calcula numarul de saptamani pentru ca nu exista valori");
    }

    @Test
    public void getNrSaptamaniPesteMedieCardinalityUnuTest()
            throws ValoriInvalideProdusException, ValoriLipsaProdusException {
        ArrayList<Integer> produseVanduteSaptamanalCardinality = new ArrayList<>() {{
            add(500);
        }};
        produs.setVanzari(produseVanduteSaptamanalCardinality);
        int nrSaptamaniPesteMedie = produs.getNrSaptamaniPesteMedie(Produs.MIN_PRODUSE_VANDUTE_SAPTAMANA);
        assertEquals(produseVanduteSaptamanalCardinality.size(), nrSaptamaniPesteMedie);
    }

    //2 teste de tip Ordering pentru getNrSaptamaniPesteMedie();


    //numai pentru getNrSaptamaniPesteMedie() un test de performanță / timp care va verifica dacă funcția returnează un rezultat sub 3 secunde pentru o lista cu 1000 de săptămâni
    @Test(timeout = 3000)
    public void getNrSaptamaniPesteMediePerformantaTest()
            throws ValoriInvalideProdusException, ValoriLipsaProdusException {
        produs.setVanzari(produseVanduteSaptamanalPerfomanta);
        produs.getNrSaptamaniPesteMedie(0);
    }

    //2 teste la alegere pentru a verifica alte criterii (altele decât cele de mai sus) pentru orice metodă.

}
