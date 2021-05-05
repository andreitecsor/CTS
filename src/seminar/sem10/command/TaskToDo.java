package seminar.sem10.command;

public class TaskToDo extends TaskAsincron {
    InterfataModulJoc modulJoc = null;
    String info;
    int prioritate;

    public TaskToDo(InterfataModulJoc modulJoc, String info, int prioritate) {
        this.modulJoc = modulJoc;
        this.info = info;
        this.prioritate = prioritate;
    }

    @Override
    public void executaTask() {
        if (this.modulJoc != null) {
            this.modulJoc.executaActiune(info);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
