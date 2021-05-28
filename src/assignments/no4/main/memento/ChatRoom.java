package assignments.no4.main.memento;

import assignments.no4.main.provided.InterfataServer;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ChatRoom implements InterfataServer {
    private String adresaIp;
    private int port;
    private static final int NR_MAX_CONEXIUNI = 1000;
    private boolean esteDisponibil = false;
    private Map<LocalDateTime, String> conversatie;

    public ChatRoom(String adresaIp, int port) {
        this.adresaIp = adresaIp;
        this.port = port;
        conversatie = new HashMap<>();
    }

    public void adaugaMesaj(String username, String mesaj) {
        conversatie.put(LocalDateTime.now(), username + ":" + mesaj);
    }

    public ChatRoomBackup salveazaConversatie() {
        return new ChatRoomBackup(conversatie);
    }

    public void restaureazaConversatie(ChatRoomBackup backup) {
        this.conversatie = backup.getConversatie();
    }

    public void stergeConversatia() {
        this.conversatie.clear();
    }

    public Map<LocalDateTime, String> getConversatie() {
        return conversatie;
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
}
