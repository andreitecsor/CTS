package seminar.sem11.subject.adapter;

public interface ContBancar {
    void transfer(ContBancar contBancar, double suma);
    void depune(double suma);
}
