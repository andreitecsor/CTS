package course.design_patterns.singleton;

public class MainSingleton {
    public static void main(String[] args) {
        DatabaseConnection con1 = DatabaseConnection.getInstance();
        DatabaseConnection con2 = DatabaseConnection.getInstance();

        //Not Clean
        //DatabaseConnection con1 = DatabaseConnection.getInstance("127.0.0.1", 3306, "bachelor");
        //DatabaseConnection con2 = DatabaseConnection.getInstance("10.0.0.1", 3306, "exam");

        if (con1 == con2) {
            System.out.println("References to the same object");
        }
    }
}
