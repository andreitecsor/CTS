package seminar.sem12.testare.teste;

import org.junit.*;
import seminar.sem12.testare.exceptii.ExceptieImpartireLaZero;
import seminar.sem12.testare.modele.OperatiiMatematice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestOperatiiMatematice {

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Salut");
    }

    @AfterClass
    public static void tearDownUpBeforeClass() {
        System.out.println("La revedere");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Pregatire test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Stergere resurse folosite");
    }

    @Test
    public void testAdunaValoriPozitive() {
        int a = 5;
        int b = 5;
        int rezultatAsteptat = 10;
        int rezultatCalculat = OperatiiMatematice.aduna(a, b);
        assertEquals("Suma cu numere pozitive", rezultatAsteptat, rezultatCalculat);
    }

    @Test
    public void testImpartireValoriPozitive() {
        int a = 1;
        int b = 2;
        double rezultatAsteptat = 0.5;
        double rezultatCalculat = 0;
        try {
            rezultatCalculat = OperatiiMatematice.impartire(a, b);
        } catch (ExceptieImpartireLaZero exceptieImpartireLaZero) {
            fail("Am primit exceptie, desi nu trebuia");
        }
        System.out.println(rezultatCalculat);
        assertEquals("Impartire 1/2", rezultatAsteptat, rezultatCalculat, 1 );
    }


}