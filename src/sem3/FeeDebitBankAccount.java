package sem3;

public class FeeDebitBankAccount extends DebitBankAccount {
    private long fee = 2;

    public FeeDebitBankAccount(String iban, Person accountHolder) {
        super(iban, accountHolder);
    }

    @Override
    public void withdraw(long amount) throws InsufficientFundsException {
        System.out.println("Adding " + fee + " fee to withdrawal");
        super.withdraw(amount + fee);
    }
}
