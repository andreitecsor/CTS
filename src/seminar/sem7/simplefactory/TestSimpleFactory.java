package seminar.sem7.simplefactory;

public class TestSimpleFactory {
    public static void main(String[] args) {
//        SuperErouAbstract supererou = new CaracterDisney("Mickey Mouse", 100, false);
//        supererou = new CaracterMarvel("Spider-man", 150, 50);
//        supererou = new CaracterDCComics("Batman", 150, 100);

        SuperErouAbstract superCaracter1 = FactorySuperErou.getSuperErou(TipErou.DISNEY, "Mickey Mouse");
        SuperErouAbstract superCaracter2 = FactorySuperErou.getSuperErou(TipErou.MARVEL, "Spider-man");
        superCaracter2 = FactorySuperErou.getSuperErou(TipErou.DC, "Batman");

    }
}
