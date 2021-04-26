package tecsor.andrei.g1087.prototype;

import java.util.ArrayList;

public class Badge implements Cloneable {
    private ColourStyle type;
    private String logoPath;
    private ArrayList<Byte> complex3DData;

    private Badge() {
    }

    public Badge(ColourStyle type, String logoPath) {
        this.type = type;
        this.logoPath = logoPath;
        this.complex3DData = ModelGenerator.generateVeryVeryComplex3DModel();
    }

    @Override
    public Badge clone() throws CloneNotSupportedException {
        Badge clone = new Badge();
        clone.type = this.type;
        clone.logoPath = this.logoPath;
        clone.complex3DData = (ArrayList<Byte>) this.complex3DData.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "type=" + type +
                ", logoPath='" + logoPath + '\'' +
                ", complex3DData=" + complex3DData +
                '}';
    }
}
