package seminar.sem11.observer;

public class ModulAutoSalvare implements InterfataStatusConexiune {
    @Override
    public void notificarePierdereConexiune() {
        System.out.println("Salvare automata joc");
    }
}
