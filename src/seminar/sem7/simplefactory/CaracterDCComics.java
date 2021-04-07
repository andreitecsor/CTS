package seminar.sem7.simplefactory;

public class CaracterDCComics extends SuperErouAbstract {
    int putereLovitura;

    public CaracterDCComics(String nume, int puncteViata, int putereLovitura) {
        super(nume, puncteViata);
        this.putereLovitura = putereLovitura;
    }

    @Override
    public void seDeplaseaza() {
    }
}
