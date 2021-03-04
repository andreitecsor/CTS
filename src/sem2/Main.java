package sem2;

import sem2.solid.BankAccount;
import sem2.solid.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ardei");
        BankAccount account = new BankAccount("INGB123412341234", person);
    }
}
