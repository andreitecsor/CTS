package seminar.sem6.prototype;

public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {

        Model3DCharacter superman1 = new Model3DCharacter("blue");
        Model3DCharacter superman2 = (Model3DCharacter) superman1.clone();
        System.out.println(superman1);
        System.out.println(superman2);
    }
}
