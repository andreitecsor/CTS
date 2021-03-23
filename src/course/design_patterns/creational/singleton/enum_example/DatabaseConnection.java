package course.design_patterns.creational.singleton.enum_example;

public enum DatabaseConnection {
    DATABASE_CONNECTION;

    String ip;
    int port;
    String database;

    DatabaseConnection() {
        System.out.println("Call enum constructor");
        ip = "127.0.0.1";
        port = 3306;
        database = "bachelor";
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }
}
