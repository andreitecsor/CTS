package seminar.sem6.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model3DCharacter implements Cloneable {
    String culoare;
    int inaltime;

    ArrayList<Integer> puncte = new ArrayList<>();

    private Model3DCharacter() {
    }

    public Model3DCharacter(String culoare) {
        this.culoare = culoare;
        System.out.println("Incarcare model 3d din fisier...");
        try {
            Thread.sleep(2000);
            Random random = new Random(10);
            for (int i = 0; i < 20; i++) {
                this.puncte.add(random.nextInt(1000));

            }
            System.out.println("Model 3D generat");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Model3DCharacter copie = new Model3DCharacter();
        copie.culoare = this.culoare;
        copie.inaltime = this.inaltime;
        copie.puncte = (ArrayList<Integer>) this.puncte.clone();
        return copie;
    }

    @Override
    public String toString() {
        return "Model3DCharacter{" +
                "culoare='" + culoare + '\'' +
                ", inaltime=" + inaltime +
                ", puncte=" + puncte +
                '}';
    }
}
