package course.design_patterns.singleton.ref_static;

public class DatabaseConnection {
    String ip;
    int port;
    String database;

    //reference to the unique object
    //eager-instantiation
    public final static DatabaseConnection instance = new DatabaseConnection();

    //static constructor of the class
    //called only once when class is loaded by JVM
    static {
        System.out.println("Loading class by JVM");
        System.out.println("Getting configuration information for the application");
    }

    //called before each constructor
    {
        System.out.println("Call before constructor");
    }

    private DatabaseConnection() {
        //getting connection values from file, web services, etc
        System.out.println("Create connection");
    }


}
