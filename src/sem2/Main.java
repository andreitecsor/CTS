package sem2;

import sem2.solid.BankAccount;
import sem2.solid.FeeBankAccount;
import sem2.solid.InsufficientFundsException;
import sem2.solid.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ardei");
        BankAccount account = new BankAccount("INGB123412341234", person);

        account.deposit(100);

        try {
            account.withdraw(30);
            account.withdraw(40);
            account.withdraw(70);

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(account.getBalance());

        account = new FeeBankAccount("INGB123412341234", person);
        account.deposit(500);

        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(account.getBalance());
    }
}
