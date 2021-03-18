package sem4.singleton;

public class Elvis {

    public final static Elvis theOneAndOnly = new Elvis();

    private Elvis() {
    }

    public void sing() {
        System.out.println("Oh mama!");
    }
}
