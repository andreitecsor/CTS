package seminar.sem4.singleton;

public class Elvis {

    private static Elvis theOneAndOnly;

    public static Elvis getInstance() {
        if (theOneAndOnly == null) {
            synchronized (Elvis.class) {
                if (theOneAndOnly == null) {
                    theOneAndOnly = new Elvis();
                }
            }
        }
        return theOneAndOnly;
    }

    private Elvis() {
    }

    public void sing() {
        System.out.println("Oh mama!");
    }
}
