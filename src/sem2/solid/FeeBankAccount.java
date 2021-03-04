package sem2.solid;

public class FeeBankAccount extends BankAccount {
    private long fee = 2;

    public FeeBankAccount(String iban, Person accountHolder) {
        super(iban, accountHolder);
    }

    @Override
    public void withdraw(long amount) throws InsufficientFundsException {
        System.out.println("Adding " + fee + " fee to withdrawal");
        super.withdraw(amount + 2);
    }
}
