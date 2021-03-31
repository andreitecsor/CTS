package seminar.sem6.builder;

public class TestBuilder {
    public static void main(String[] args) {
        SuperErou vlad = new SuperErou.SuperErouBuilder("Vlad the Impaler", 100)
                .setArmaDreapta(new Arma())
                .setArmaStanga(new Arma())
                .build();

        SuperErou thief = new SuperErou.SuperErouBuilder("Thief", 50)
                .esteNegativ()
                .esteRanit()
                .build();

        SuperErou thief2 = new SuperErou.SuperErouBuilder("Thief", 50)
                .esteNegativ()
                .esteRanit()
                .build();
    }
}