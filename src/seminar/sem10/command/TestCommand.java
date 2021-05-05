package seminar.sem10.command;

public class TestCommand {
    public static void main(String[] args) {
        TaskAsincron autoSave = new TaskToDo(new ModulAutoSave(), "Autosave", 5);
        TaskAsincron autoUpdate = new TaskToDo(new ModulUpdateClient(), "Update v2", 20);

        //executie task-uri asincrone
        autoSave.executaTask();
        autoUpdate.executaTask();
    }
}
