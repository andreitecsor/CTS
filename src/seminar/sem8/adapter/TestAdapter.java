package seminar.sem8.adapter;

import java.util.ArrayList;

public class TestAdapter {
    public static void main(String[] args) {
        CaracterFantastic dragon = new CaracterFantastic("Dragonul albastru", 1000);
        dragon.seDeplaseaza();
        dragon.esteLovit(200);
        dragon.seVindeca(250);

        DonaldDuck donaldDuck = new DonaldDuck();
        donaldDuck.setPower(500);
        donaldDuck.move(100, 100);
        donaldDuck.primesteLovitura(50);
        donaldDuck.jump();

        ArrayList<ACMECaracterJoc> caractere = new ArrayList<>();
        caractere.add(dragon);

        AdaptorDisneyLaAcme adaptorDonald = new AdaptorDisneyLaAcme(donaldDuck);
        caractere.add(adaptorDonald);
        System.out.println("----");
        for (ACMECaracterJoc acmeCaracterJoc : caractere) {
            acmeCaracterJoc.seDeplaseaza();
            acmeCaracterJoc.esteLovit(50);
        }
    }
}
