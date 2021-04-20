package seminar.sem8.decorator;

import seminar.sem8.adapter.ACMECaracterJoc;

public class DecoratorScut extends DecoratorCaracter {

    private int nivelScut;

    public DecoratorScut(ACMECaracterJoc caracterJoc, int nivelScut) {
        super(caracterJoc);
        this.nivelScut = nivelScut;
    }

    @Override
    public void esteLovit(int puncte) {
        int puncteLovitura = puncte - this.nivelScut;
        if (puncteLovitura > 0) {
            this.caracterJoc.esteLovit(puncteLovitura);
        }

    }
}
