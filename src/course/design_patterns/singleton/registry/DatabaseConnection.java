package course.design_patterns.singleton.registry;

import java.util.HashMap;

public class DatabaseConnection {
    String ip;
    int port;
    String database;

    //eager-instantiation
    private static HashMap<String, DatabaseConnection> connectionRegistry = new HashMap<>();

    private DatabaseConnection(String ip, int port, String db) {
        System.out.println("Create connection");
        this.ip = ip;
        this.port = port;
        this.database = db;
    }


    public static DatabaseConnection getInstance(String ip, int port, String db) {
        DatabaseConnection connection = connectionRegistry.get(ip);
        if (connection == null) {
            //lazy-instantiation
            connection = new DatabaseConnection(ip, port, db);
            connectionRegistry.put(ip, connection);
        }
        return connection;
    }

}
