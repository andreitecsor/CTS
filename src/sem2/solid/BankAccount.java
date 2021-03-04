package sem2.solid;

public class BankAccount {
    private long balance;
    private String iban;
    private Person accountHolder;


    public BankAccount(String iban, Person accountHolder) {
        this.iban = iban;
        this.accountHolder = accountHolder;
        this.balance = 0;
    }

    public void withdraw(long amount) {
        balance -= amount;
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Person getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(Person accountHolder) {
        this.accountHolder = accountHolder;
    }
}
