package seminar.sem8.adapter;

public class DonaldDuck implements ActiuniDisney {

    public static final String DENUMIRE = "Donald Duck";

    private int power;

    public static String getDENUMIRE() {
        return DENUMIRE;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Repozitionare caracter la noile coordate");
    }

    @Override
    public void primesteLovitura(int power) {
        this.power -= power;
        System.out.println("Nivelul putere scade la " + this.power);
    }

    @Override
    public void reincarca(int power) {
        this.power += power;
        System.out.println("Nivelul putere reincarcat la " + this.power);
    }

    @Override
    public void jump() {
        System.out.println("Jump");
    }
}
