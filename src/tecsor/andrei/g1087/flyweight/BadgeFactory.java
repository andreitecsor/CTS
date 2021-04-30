package tecsor.andrei.g1087.flyweight;

public class BadgeFactory {
    private static String BRONZE_BADGE_PATH = "src/main/resources/badge3Dmodel/bronze.FBX";
    private static String SILVER_BADGE_PATH = "src/main/resources/badge3Dmodel/silver.FBX";
    private static String GOLD_BADGE_PATH = "src/main/resources/badge3Dmodel/gold.FBX";
    private static String PLATINUM_BADGE_PATH = "src/main/resources/badge3Dmodel/platinum.FBX";

    public static Model3D getBadgeModel(BadgeType type) {
        Model3D badge = null;
        switch (type) {
            case BRONZE:
                badge = new Badge(type, BRONZE_BADGE_PATH);
                break;
            case SILVER:
                badge = new Badge(type, SILVER_BADGE_PATH);
                break;
            case GOLD:
                badge = new Badge(type, GOLD_BADGE_PATH);
                break;
            case PLATINUM:
                badge = new Badge(type, PLATINUM_BADGE_PATH);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        badge.generate();
        return badge;
    }
}
