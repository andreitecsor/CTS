package seminar.sem6.builder;

public class TestBuilder {
    public static void main(String[] args) {
        //1. construiesti obiectul
        SuperErou superErou = new SuperErou();
        superErou.nume = "SuperDavid";

        SuperErou superErou2 = new SuperErou("AnduMan", 100, false, false, new Arma(), null, null, null);
    }
}