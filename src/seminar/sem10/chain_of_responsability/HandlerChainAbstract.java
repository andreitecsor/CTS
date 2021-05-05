package seminar.sem10.chain_of_responsability;

public abstract class HandlerChainAbstract {
    HandlerChainAbstract next = null;

    String numeModul;

    public HandlerChainAbstract(String numeModul) {
        this.numeModul = numeModul;
    }

    public void setNext(HandlerChainAbstract next) {
        this.next = next;
    }

    public abstract void procesareMesajChat(MesajChat mesaj);
}
