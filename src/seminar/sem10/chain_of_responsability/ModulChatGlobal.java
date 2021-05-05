package seminar.sem10.chain_of_responsability;

public class ModulChatGlobal extends HandlerChainAbstract {

    public ModulChatGlobal() {
        super("Modul chat global");
    }

    @Override
    public void procesareMesajChat(MesajChat mesaj) {
        if (mesaj.getDestinatie().isEmpty() || mesaj.getDestinatie().equals("@Everyone")) {
            System.out.println("Mesaj catre toti jucatorii: " + mesaj.getContinut());
        }

        if (this.next != null) {
            this.next.procesareMesajChat(mesaj);
        }
    }
}
