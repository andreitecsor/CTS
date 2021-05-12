package seminar.sem11.memento;

public class CaracterJoc {
    String denumire;
    int puncteViata;
    String abilitatiMagice;

    public CaracterJoc(String denumire, int puncteViata, String abilitatiMagice) {
        this.denumire = denumire;
        this.puncteViata = puncteViata;
        this.abilitatiMagice = abilitatiMagice;
    }

    public void ataca() {

    }

    public void seVindeca(int valoare) {
        this.puncteViata += valoare;
    }

    public void seDepleaseaza() {

    }

    public MementoCaracterJoc salvare() {
        return new MementoCaracterJoc(this.denumire, this.puncteViata, this.abilitatiMagice);
    }

    public void incarcareSalvare(MementoCaracterJoc salvare) {
        this.denumire = salvare.denumire;
        this.puncteViata = salvare.puncteViata;
        this.abilitatiMagice = salvare.abilitatiMagice;
    }
}
