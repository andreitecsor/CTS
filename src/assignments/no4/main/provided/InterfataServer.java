package assignments.no4.main.provided;

public interface InterfataServer {

    public String getAdresaIp();
    public int getPort();
    public int getNrMaximConexiuni();

    public boolean conectare();
    public boolean deconectare();

}