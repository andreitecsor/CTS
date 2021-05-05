package seminar.sem10.command;

public class ModulAutoSave implements InterfataModulJoc {

    @Override
    public void executaActiune(String numeActiune) {
        System.out.println("Se realizeaza auto-save pentru " + numeActiune);
    }
}
