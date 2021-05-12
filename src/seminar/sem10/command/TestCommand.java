package seminar.sem10.command;

public class TestCommand {
    public static void main(String[] args) {
        ManagerTaskuri managerTaskuri = new ManagerTaskuri();

        TaskAsincron autoSave = new TaskToDo(new ModulAutoSave(), "Autosave", 5);
        TaskAsincron autoUpdate = new TaskToDo(new ModulUpdateClient(), "Update v2", 20);

        managerTaskuri.adaugaTask(autoSave);
        managerTaskuri.adaugaTask(autoUpdate);
        System.out.println("Jocul este activ");
        managerTaskuri.executaTask();
        managerTaskuri.executaTask();
        System.out.println("Jocul este activ");

        //executie task-uri asincrone
//        autoSave.executaTask();
//        autoUpdate.executaTask();
    }
}
