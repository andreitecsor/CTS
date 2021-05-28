package seminar.assignments.no3.flyweight;

import java.util.ArrayList;
import java.util.Random;

public class ModelGenerator {

    public static ArrayList<Byte> generateVeryVeryComplex3DModel(String modelPath) {
        try {
            System.out.println("Generating model from file " + modelPath + "...");
            Thread.sleep(1000);
            return new ArrayList<>() {
                {
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(15))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(8))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(70))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(13))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(15))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(100))));
                    add(Byte.valueOf(String.valueOf(new Random().nextInt(3))));
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
