package seminar.sem7.simplefactory;

public class TestSimpleFactory {
    public static void main(String[] args) {
//        SuperErouAbstract supererou = new CaracterDisney("Mickey Mouse", 100, false);
//        supererou = new CaracterMarvel("Spider-man", 150, 50);
//        supererou = new CaracterDCComics("Batman", 150, 100);

        SuperErouAbstract supererou = null;
        boolean selectieTemaUniversala = true;

        if (selectieTemaUniversala) {
            supererou = FactorySuperErou.getSuperErou(TipErou.DISNEY, "Mickey Mouse");
            supererou = FactorySuperErou.getSuperErou(TipErou.MARVEL, "Spider-man");
            supererou = FactorySuperErou.getSuperErou(TipErou.DC, "Batman");
        } else {
            //folosesti caractere din tema originala a jocului
        }
    }
}
