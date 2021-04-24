package tecsor.andrei.g1087;

import tecsor.andrei.g1087.singleton.Neo4JConnection;

public class TestAssignment {
    public static void main(String[] args) {
        //SINGLETON
        Neo4JConnection connection = Neo4JConnection.getInstance();
        Neo4JConnection connection2 = Neo4JConnection.getInstance();
        System.out.println(connection);
        System.out.println(connection2);
        if (connection.equals(connection2)) {
            System.out.println("Singleton");
        }
        

    }
}
