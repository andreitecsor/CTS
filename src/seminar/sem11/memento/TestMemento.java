package seminar.sem11.memento;

public class TestMemento {
    public static void main(String[] args) {

        CaracterJoc superman = new CaracterJoc("Superman", 100, "zboara");

        MementoCaracterJoc salvareInceputJoc = superman.salvare();

        superman.ataca();
        superman.seVindeca(200);
        System.out.println("Puncte viata:" + superman.puncteViata);

        superman.incarcareSalvare(salvareInceputJoc);
        System.out.println("Puncte viata:" + superman.puncteViata);

    }
}
