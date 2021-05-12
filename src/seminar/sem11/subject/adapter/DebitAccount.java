package seminar.sem11.subject.adapter;

public class DebitAccount implements BankAccount {
    double value;
    int id;

    @Override
    public void accountTransfer(BankAccount account, double amount) {
        DebitAccount debit = (DebitAccount) account;
        debit.value += amount;
        this.value -= amount;
    }
}
