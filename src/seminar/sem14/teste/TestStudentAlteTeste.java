package seminar.sem14.teste;

import org.junit.*;
import seminar.sem14.exceptii.ExceptieNota;
import seminar.sem14.exceptii.ExceptieVarsta;
import seminar.sem14.modele.Student;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

public class TestStudentAlteTeste {

    //Test fixture
    static Student student;
    static ArrayList<Integer> note;
    static String numeInitial;
    static int varstaInitiala;
    static int nrNoteInitiale;

    static ArrayList<Integer> noteTestPerformanta;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        note = new ArrayList<>();
        nrNoteInitiale = 3;
        Random random = new Random();
        for (int i = 0; i < nrNoteInitiale; i++){
            note.add(random.nextInt(Student.MAX_NOTA) + 1);
        }
        numeInitial = "Gigel";
        varstaInitiala = Student.MIN_VARSTA  + 1;

        noteTestPerformanta = new ArrayList<>();
        int nrNote = 100000;
        for (int i=0; i<nrNote; i++){
            noteTestPerformanta.add(Student.MAX_NOTA);
        }
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{

    }

    @Before
    public void setUp() throws Exception {
        student = new Student(numeInitial, varstaInitiala, note);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test(expected = ExceptieVarsta.class)
    public void testRangeSetVarstaMinInt() throws ExceptieVarsta {
        int varstaNoua = Integer.MIN_VALUE;
        student.setVarsta(varstaNoua);
    }

    @Test(expected = ExceptieVarsta.class)
    public void testRangeSetVarstaMaxInt() throws ExceptieVarsta {
        int varstaNoua = Integer.MAX_VALUE;
        student.setVarsta(varstaNoua);
    }

    @Test
    public void testBoundaryVarstaMinimaRightSetVarsta() throws ExceptieVarsta {
        int varstaNoua = Student.MIN_VARSTA;
        student.setVarsta(varstaNoua);

        int varstaModificata = student.getVarsta();
        assertEquals("Test pentru limita inferioara varsta", varstaNoua, varstaModificata);
    }

    @Test
    public void testBoundaryVarstaMaximaRightSetVarsta() throws ExceptieVarsta {
        int varstaNoua = Student.MAX_VARSTA;
        student.setVarsta(varstaNoua);

        int varstaModificata = student.getVarsta();
        assertEquals("Test pentru limita inferioara varsta", varstaNoua, varstaModificata);
    }

    @Test
    public void testReferenceSetNoteDeepCopy() throws ExceptieNota {
        //obj extern
        ArrayList<Integer> note = new ArrayList<>();
        note.add(10);
        note.add(10);
        note.add(10);
        student.setNote(note);

        int[] noteStudent = new int[student.getNrNote()];
        for (int i = 0; i < student.getNrNote(); i++){
            noteStudent[i] = student.getNota(i);
        }

        note.set(0, 5);

        //testam daca modif starea obj extern nu afecteaza obj curent
        //shallow-copy
        int[] noteStudentDupaModificare = new int[student.getNrNote()];
        for (int i = 0; i < student.getNrNote(); i++){
            noteStudentDupaModificare[i] = student.getNota(i);
        }

        assertArrayEquals("Test modificare colectie note externa obiectului", noteStudent, noteStudentDupaModificare);
    }

    @Test
    public void testPerformanceGetMedie() throws ExceptieNota {
        ArrayList<Integer> note = new ArrayList<>();
        int nrNote = 100000;
        for (int i=0; i < nrNote; i++){
            note.add(Student.MAX_NOTA);
        }
        student.setNote(note);

        long tStart = System.currentTimeMillis();
        float medieCalculata = student.getMedie();
        long tFinal = System.currentTimeMillis();

        long durataMinima = 1000;  //100ms
        long durata = tFinal - tStart;
        if (durata < durataMinima){
            assertTrue(true);
        }
        else{
            fail("Testul a depasit durata minima");
        }
    }

    @Test(timeout = 10)
    public void testPerformanceGetMedieJUnit4() throws ExceptieNota {
//        ArrayList<Integer> note = new ArrayList<>();
//        int nrNote = 100000;
//        for (int i=0; i < nrNote; i++){
//            note.add(Student.MAX_NOTA);
//        }
        student.setNote(noteTestPerformanta);

        student.getMedie();
    }

    @Test //aici nu avem expected
    public void testInverseRelationshipGetNotaMinima() throws ExceptieNota {
        ArrayList<Integer> note = new ArrayList<>();
        int nrNote = 10000;
        Random random = new Random();
        for (int i=0; i < nrNote; i++){
            note.add(random.nextInt(Student.MAX_NOTA) + 1);
        }
        student.setNote(note);

        int minimCalculat = student.getNotaMinima();

        //pentru ca nu putem determina val estimata
        //verificam relatia dintre minim si valorile initiale
        for (int i=0; i< nrNote; i++){
            if (minimCalculat > note.get(i)){
                fail("Minimul calculat nu este corect");
            }
        }
        assertTrue(true);
    }

    @Test //verifici daca rez nou  este identic cu rez dinainte
    public void testCrossCheckGetMedie() throws ExceptieNota {
        ArrayList<Integer> note = new ArrayList<>();
        int nrNote = 10000;
        Random random = new Random();
        for (int i=0; i < nrNote; i++){
            note.add(random.nextInt(Student.MAX_NOTA) + 1);
        }
        student.setNote(note);

        float medieEstimata = getMedieVariantaInitiala(note);
        float medieCalculata = student.getMedie();

        assertEquals("Valorile calculate de cele 2 functii nu sunt identice", medieEstimata, medieCalculata, 0);
    }

    public float getMedieVariantaInitiala(ArrayList<Integer> valori){
        float suma = 0;
        for (int valoare : valori){
            suma += valoare;
        }
        return suma/valori.size();
    }













}