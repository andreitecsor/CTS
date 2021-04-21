package seminar.sem9.state;

public class TestState {
    public static void main(String[] args) {
        SuperErou superErou = new SuperErou("Superman", 100);
        superErou.seDeplaseaza();
        superErou.esteAtacat(50);
        superErou.seDeplaseaza();
        superErou.esteAtacat(45);
        superErou.seDeplaseaza();
        superErou.seVindeca(30);
        superErou.seDeplaseaza();
    }
}
