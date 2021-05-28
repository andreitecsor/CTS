package seminar.assignments.no3.flyweight;


import java.util.List;

public class Badge implements Model3D {
    private BadgeType type;
    private String modelPath;
    private List<Byte> complex3DData = null;

    protected Badge(BadgeType type, String modelPath) {
        this.type = type;
        this.modelPath = modelPath;
    }

    @Override
    public void generate() {
        this.complex3DData = ModelGenerator.generateVeryVeryComplex3DModel(this.modelPath);
    }

    @Override
    public void show(BadgeDetails badgeDetails) {
        System.out.println(badgeDetails.getUserDisplayName() + " earned a "
                + this.type.toString() + " badge on "
                + badgeDetails.getEarnedAt().toString()
                + " [generated from " + badgeDetails.getChallengeLogoPath() + "]");
    }
}
