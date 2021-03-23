package course.design_patterns.singleton.ref_static;

public class MainSingletonRef {
    public static void main(String[] args) {
        System.out.println("Starting the app...");
        DatabaseConnection con1 = DatabaseConnection.instance;
        DatabaseConnection con2 = DatabaseConnection.instance;

    }
}
