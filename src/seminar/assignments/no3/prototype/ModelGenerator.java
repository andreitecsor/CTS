package seminar.assignments.no3.prototype;

import java.util.ArrayList;
import java.util.Random;

public class ModelGenerator {

    public static ArrayList<Byte> generateVeryVeryComplex3DModel() {
        try {
            System.out.println("I'm starting to work... hold my beer");
            Thread.sleep(5000);
            System.out.println("That was hard but here you have it. I need a break");
            return new ArrayList<>() {
                {
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(10))));
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
