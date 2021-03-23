package course.design_patterns.creational.singleton.registry;

public class MainSingletonRegistry {
    public static void main(String[] args) {
        DatabaseConnection connection1 = DatabaseConnection.getInstance("127.0.0.1", 3306, "test");
        DatabaseConnection connection2 = DatabaseConnection.getInstance("10.0.0.1", 3306, "prod");

        if (connection1 != connection2) {
            System.out.println("Different connections to different servers");
        }

        DatabaseConnection connection3 = DatabaseConnection.getInstance("10.0.0.1", 3306, "prod");
        if (connection3 == connection2) {
            System.out.println("Same connections");
        }
    }
}
