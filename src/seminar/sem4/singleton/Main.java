package seminar.sem4.singleton;

public class Main {
    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.sing();

        Elvis elvis1 = Elvis.getInstance();
        System.out.println(elvis == elvis1);

        ElvisV2 elvisV2 = ElvisV2.INSTANCE;
        elvisV2.sing();
    }
}
