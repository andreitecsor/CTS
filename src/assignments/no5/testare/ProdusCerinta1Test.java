package assignments.no5.testare;

import assignments.no5.exceptii.ValoriInvalideProdusException;
import assignments.no5.model.Produs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProdusCerinta1Test {
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

    //cel puțin 1 test Right / Conformance pentru fiecare constructor
    @Test
    public void constructor2ParametriNumeCorectTest() {
        assertEquals(numeInitial, produs.getNume());
    }

    @Test
    public void constructor2ParametriPretCorectTest() {
        assertEquals(pretInitial, produs.getPret(), 0);
    }

    @Test
    public void constructor3ParametriProduseVanduteCorecteTest() {
        assertEquals(produseVanduteSaptamanal, produsCuVanzari.getProduseVanduteSaptamanal());
    }

    //cel puțin 2 teste Error Condition pentru fiecare constructor
    @Test(expected = ValoriInvalideProdusException.class)
    public void constructor2ParametriNumeCuCaractereSpecialeTest() throws ValoriInvalideProdusException {
        Produs produs = new Produs("Laptop#$%", pretInitial);
        fail("Nu am primit exceptie pentru nume invalid");
    }

    @Test(expected = ValoriInvalideProdusException.class)
    public void constructor2ParametriPretNegativTest() throws ValoriInvalideProdusException {
        Produs produs = new Produs("LaptopAsus", Produs.PRET_MIN - 100);
        fail("Nu am primit exceptie pentru pret negativ");
    }

    @Test(expected = ValoriInvalideProdusException.class)
    public void constructor3ParametriPretPozitivMaiMareDecatMaximTest() throws ValoriInvalideProdusException {
        ArrayList<Integer> produseVanduteSaptamanal = new ArrayList<>() {
            {
                add(350);
                add(450);
                add(376);
            }
        };
        Produs produs = new Produs(numeInitial, Produs.PRET_MAX + 1, produseVanduteSaptamanal);
        fail("Nu am primit exceptie pentru pret mai mare decat pretul maxim");

    }

    @Test(expected = ValoriInvalideProdusException.class)
    public void constructor3ParametriNumeNullTest() throws ValoriInvalideProdusException {
        Produs produs = new Produs(null, pretInitial, produseVanduteSaptamanal);
        fail("Nu am primit exceptie pentru nume null");
    }

    //1 test Reference pentru constructorul care primește ArrayList
    @Test
    public void constructor3ParametriReferenceArrayListTest() {
        produseVanduteSaptamanal.set(0, 500);
        assertNotEquals(produsCuVanzari.getProduseVanduteSaptamanal(), produseVanduteSaptamanal);
    }

    //1 test Existence pentru constructorul care primește ArrayList
    @Test(expected = ValoriInvalideProdusException.class)
    public void constructor3ParametriExistenceArrayListTest() throws ValoriInvalideProdusException {
        Produs produs = new Produs(numeInitial, pretInitial, null);
        fail("Nu am primit exceptie pentru valoarea null a listei");
    }

    //1 test Reference pentru setVanzari()
    @Test
    public void setVanzariReferenceArrayListTest() throws ValoriInvalideProdusException {
        produs.setVanzari(produseVanduteSaptamanal);
        produseVanduteSaptamanal.set(0, 999);
        assertNotEquals(produs.getProduseVanduteSaptamanal(), produseVanduteSaptamanal);
    }

    //1 test Existence pentru setVanzari()
    @Test(expected = ValoriInvalideProdusException.class)
    public void setVanzariExistenceArrayListTest() throws ValoriInvalideProdusException {
        produsCuVanzari.setVanzari(null);
        fail("Nu am primit exceptie pentru valoarea null a listei");
    }
}