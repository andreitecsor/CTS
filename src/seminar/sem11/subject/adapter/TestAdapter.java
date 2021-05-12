package seminar.sem11.subject.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        ContBancarDebit cont = new ContBancarDebit(100,"RO123");
        BankAccount account = new AdapterCont2Account(cont);

        account.accountTransfer(new DebitAccount(),50);

        System.out.println("Valoare in cont: " + cont.balanta);
    }
}
