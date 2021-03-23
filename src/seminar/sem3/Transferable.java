package seminar.sem3;

public interface Transferable {

    void transfer(Receivable destination, long amount) throws InsufficientFundsException;

}
