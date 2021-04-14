package seminar.sem8.decorator;

import seminar.sem8.adapter.ACMECaracterJoc;
import seminar.sem8.adapter.CaracterFantastic;

public class TestDecorator {
    public static void main(String[] args) {
        ACMECaracterJoc dragon = new CaracterFantastic("Dragonul albastru", 400);
        dragon.seDeplaseaza();
        dragon.esteLovit(200);
        dragon.seVindeca(100);

//        ACMECaracterJoc dragonCuScut = new DecoratorScut(dragon, 200);
        dragon = new DecoratorScut(dragon, 200);
        dragon.esteLovit(300);

        dragon = new DecoratorRanit(dragon);
        dragon.esteLovit(50);
        dragon.seDeplaseaza();
    }
}
