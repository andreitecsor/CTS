package seminar.sem11.memento;

import java.time.LocalDateTime;

public class MementoCaracterJoc {
    String denumire;
    int puncteViata;
    String abilitatiMagice;

    LocalDateTime momentSalvare;

    public MementoCaracterJoc(String denumire, int puncteViata, String abilitatiMagice) {
        this.denumire = denumire;
        this.puncteViata = puncteViata;
        this.abilitatiMagice = abilitatiMagice;
        momentSalvare = LocalDateTime.now();
    }
}
