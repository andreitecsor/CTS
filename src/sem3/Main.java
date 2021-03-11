package sem3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Person, BankAccount> employees = new HashMap<>();
        Person p1 = new Person("Chuck Norris");
        BankAccount b1 = new BankAccount("RFZ123123123", p1);

        Person p2 = new Person("Arnold");
        BankAccount b2 = new FeeBankAccount("INGB123123123", p2);

        Person p3 = new Person("Van Damme");
        BankAccount b3 = new BankAccount("BT123123123", p3);

        employees.put(p1, b1);
        employees.put(p2, b2);
        employees.put(p3, b3);

        for (BankAccount a : employees.values()) {
            a.deposit(1000);
        }

        for (BankAccount a : employees.values()) {
            try {
                a.withdraw(10);
            } catch (InsufficientFundsException e) {
                e.printStackTrace();
            }
        }

    }
}
