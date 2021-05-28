package assignments.no4.main.prototype;

import assignments.no4.main.provided.InterfataServer;

import java.util.Arrays;
import java.util.List;

public class ChatRoom implements InterfataServer, Cloneable {
    private String adresaIp;
    private int port;
    private static final int NR_MAX_CONEXIUNI = 10;
    private boolean esteDisponibil = false;
    private List<String> utilizatoriConectati;
    private String conversationFile;

    private ChatRoom() {
    }

    public ChatRoom(String adresaIp, int port) throws InterruptedException {
        this.adresaIp = adresaIp;
        this.port = port;
        utilizatoriConectati = Arrays.asList(new String[NR_MAX_CONEXIUNI]);
        System.out.println("Generare chat");
        Thread.sleep(500);
        System.out.println("Generare reusită. Server Activ.");
    }

    @Override
    public String getAdresaIp() {
        return adresaIp;
    }

    @Override
    public int getPort() {
        return port;
    }

    @Override
    public int getNrMaximConexiuni() {
        return NR_MAX_CONEXIUNI;
    }

    @Override
    public boolean conectare() {
        esteDisponibil = true;
        return true;
    }

    @Override
    public boolean deconectare() {
        esteDisponibil = false;
        return true;
    }

    @Override
    public Object clone() {
        ChatRoom clone = new ChatRoom();
        clone.adresaIp = this.adresaIp;
        clone.port = this.port;
        clone.utilizatoriConectati = Arrays.asList(new String[NR_MAX_CONEXIUNI]);
        return clone;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "adresaIp='" + adresaIp + '\'' +
                ", port=" + port +
                ", esteDisponibil=" + esteDisponibil +
                ", utilizatoriConectati=" + utilizatoriConectati.size() +
                '}';
    }
}
