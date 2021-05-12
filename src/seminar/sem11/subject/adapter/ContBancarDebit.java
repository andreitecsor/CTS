package seminar.sem11.subject.adapter;

public class ContBancarDebit implements ContBancar {
    double balanta;
    String iban;

    public ContBancarDebit(double balanta, String iban) {
        this.balanta = balanta;
        this.iban = iban;
    }

    @Override
    public void transfer(ContBancar destinate, double suma) {
        destinate.depune(suma);
        this.balanta -= suma;
    }

    @Override
    public void depune(double suma) {
        this.balanta += suma;
    }
}
