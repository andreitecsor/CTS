package seminar.sem9.proxy;

public class ModulLogin implements InterfataModulLogin {
    String ipServer;
    int port;

    public ModulLogin(String ipServer, int port) {
        this.ipServer = ipServer;
        this.port = port;
    }

    @Override
    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }

    @Override
    public boolean verificaStatusServer() {
        return true;
    }
}
