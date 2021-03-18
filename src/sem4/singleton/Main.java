package sem4.singleton;

public class Main {
    public static void main(String[] args) {
        Elvis elvis = Elvis.theOneAndOnly;
        elvis.sing();
    }
}
