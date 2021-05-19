package seminar.sem12.testare.modele;

import seminar.sem12.testare.exceptii.ExceptieImpartireLaZero;

public class OperatiiMatematice {

    public static int aduna(int a, int b) {
        return a + b;
    }

    public static double impartire(int a, int b) throws ExceptieImpartireLaZero {
        if (b == 0) {
            throw new ExceptieImpartireLaZero();
        }
        return (double) a / b;
    }
}
