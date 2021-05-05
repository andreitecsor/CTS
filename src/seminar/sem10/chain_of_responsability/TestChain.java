package seminar.sem10.chain_of_responsability;

public class TestChain {
    public static void main(String[] args) {
        HandlerChainAbstract chatGlobal = new ModulChatGlobal();
        HandlerChainAbstract chatPrivat = new ModulChatPrivat();
        HandlerChainAbstract filtruChat = new ModulFiltru("Reguli limba romana");

        filtruChat.setNext(chatPrivat);
        chatPrivat.setNext(chatGlobal);

        HandlerChainAbstract serverChat = filtruChat;

        serverChat.procesareMesajChat(new MesajChat("@Everyone","Esti rau",1));
        serverChat.procesareMesajChat(new MesajChat("@Everyone","Esti ok. Multumesc",1));
        serverChat.procesareMesajChat(new MesajChat("@Gigel","Hai sa incercam urmatorul nivel",1));
    }
}
