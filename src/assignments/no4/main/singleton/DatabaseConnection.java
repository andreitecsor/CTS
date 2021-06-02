package assignments.no4.main.singleton;

import assignments.no4.main.provided.InterfataServer;

public class DatabaseConnection implements InterfataServer {
    private String adresaIp;
    private int port;
    private static DatabaseConnection instance = null;
    private static final int NR_MAX_CONEXIUNI = 1;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            instance.adresaIp = "192.0.0.1";
            instance.port = 8080;
        }
        return instance;
    }

    @Override
    public String getAdresaIp() {
        return instance.getAdresaIp();
    }

    @Override
    public int getPort() {
        return instance.port;
    }

    @Override
    public int getNrMaximConexiuni() {
        return NR_MAX_CONEXIUNI;
    }

    @Override
    public boolean conectare() {
        if (instance == null) {
            return false;
        }
        instance = getInstance();
        return true;
    }

    @Override
    public boolean deconectare() {
        if (instance == null) {
            return false;
        }
        instance = null;
        return true;
    }

}
