package course.design_patterns.creational.singleton;

public class DatabaseConnection {
    String ip;
    int port;
    String database;

    //reference to the unique object
    //lazy-instantiation: delaying the creation of the object until you need it
    private static DatabaseConnection instance = null;

    private DatabaseConnection() {
    }

//    private DatabaseConnection(String ip, int port, String bd) {
//        this.ip = ip;
//        this.port = port;
//        this.db = bd;
//    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
            //getting attributes' values from a config file
            instance.ip = "127.0.0.1";
            instance.port = 3306;
            instance.database = "bachelor";
        }
        return instance;
    }

    //case without config file
    //not Clean - on runtime generates the idea that you have more connections
    public static DatabaseConnection getInstance(String ip, int port, String database) {
        if (instance == null) {
            instance = new DatabaseConnection();
            instance.ip = ip;
            instance.port = port;
            instance.database = database;
        }
        return instance;
    }


}
