package seminar.sem11.subject.adapter;

public class AdapterCont2Account implements BankAccount {
    ContBancar cont;

    public AdapterCont2Account(ContBancar cont) {
        this.cont = cont;
    }

    @Override
    public void accountTransfer(BankAccount account, double amount) {
        ContBancarDebit contDebit = (ContBancarDebit) conversie(account);
        cont.transfer(contDebit, amount);
    }

    private ContBancarDebit conversie(BankAccount account) {
        DebitAccount debitAccount = (DebitAccount) account;
        ContBancarDebit cont = new ContBancarDebit(debitAccount.value, String.valueOf(debitAccount.id));
        return cont;
    }
}
