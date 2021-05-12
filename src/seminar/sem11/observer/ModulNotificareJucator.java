package seminar.sem11.observer;

public class ModulNotificareJucator implements InterfataStatusConexiune {

    @Override
    public void notificarePierdereConexiune() {
        System.out.println("Pop up! Conexiune internet pierduta!");
    }
}
