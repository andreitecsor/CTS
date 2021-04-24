package tecsor.andrei.g1087.singleton;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Neo4JConnection {
    private Neo4JDriver neo4JDriver;
    public static Neo4JConnection instance = null;

    private Neo4JConnection() {
    }

    public static Neo4JConnection getInstance() {
        if (instance == null) {
            try {
                instance = new Neo4JConnection();
                Properties properties = new Properties();
                properties.load(new FileReader("src/tecsor/andrei/g1087/singleton/application.properties"));
                instance.setNeo4JDriver(new Neo4JDriver(properties.getProperty("username"),
                        properties.getProperty("password"),
                        properties.getProperty("uri")));
                System.out.println("Connection established between neo4j db");
                return instance;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Connection failed");
            }
        }
        return instance;
    }

    private void setNeo4JDriver(Neo4JDriver neo4JDriver) {
        this.neo4JDriver = neo4JDriver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neo4JConnection that = (Neo4JConnection) o;

        return neo4JDriver.equals(that.neo4JDriver);
    }

    @Override
    public int hashCode() {
        return neo4JDriver != null ? neo4JDriver.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Neo4JConnection{" +
                "neo4JDriver=" + neo4JDriver +
                '}';
    }
}
