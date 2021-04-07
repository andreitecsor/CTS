package seminar.sem7.simplefactory;

public class CaracterDisney extends SuperErouAbstract {

    boolean cuAcordParental;

    public CaracterDisney(String nume, int puncteViata, boolean acord) {
        super(nume, puncteViata);
        this.cuAcordParental = acord;
    }

    @Override
    public void seDeplaseaza() {

    }
}
