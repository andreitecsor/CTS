package seminar.sem11.observer;

public class TestObserver {
    public static void main(String[] args) {
        ModulConexiuneInternet modulConexiune = new ModulConexiuneInternet();

        ModulAutoSalvare modulAutoSalvare = new ModulAutoSalvare();
        ModulNotificareJucator modulNotificareJucator = new ModulNotificareJucator();

        modulConexiune.registerModul(modulNotificareJucator);
        modulConexiune.registerModul(modulAutoSalvare);

        modulConexiune.pierdereConexiune();

        modulConexiune.unregisterModul(modulAutoSalvare);

        modulConexiune.pierdereConexiune();
    }
}
