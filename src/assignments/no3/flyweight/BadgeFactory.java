package assignments.no3.flyweight;

import java.util.HashMap;
import java.util.Map;

public class BadgeFactory {
    private static Map<BadgeType, Model3D> badgeModels = new HashMap<>();

    private static String BRONZE_BADGE_PATH = "src/main/resources/badge3Dmodel/bronze.FBX";
    private static String SILVER_BADGE_PATH = "src/main/resources/badge3Dmodel/silver.FBX";
    private static String GOLD_BADGE_PATH = "src/main/resources/badge3Dmodel/gold.FBX";
    private static String PLATINUM_BADGE_PATH = "src/main/resources/badge3Dmodel/platinum.FBX";

    public static Model3D getBadgeModel(BadgeType type) {
        Model3D badge = badgeModels.get(type);
        if (badge == null) {
            switch (type) {
                case BRONZE:
                    badge = new Badge(type, BRONZE_BADGE_PATH);
                    badge.generate();
                    badgeModels.put(type, badge);
                    break;
                case SILVER:
                    badge = new Badge(type, SILVER_BADGE_PATH);
                    badge.generate();
                    badgeModels.put(type, badge);
                    break;
                case GOLD:
                    badge = new Badge(type, GOLD_BADGE_PATH);
                    badge.generate();
                    badgeModels.put(type, badge);
                    break;
                case PLATINUM:
                    badge = new Badge(type, PLATINUM_BADGE_PATH);
                    badge.generate();
                    badgeModels.put(type, badge);
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        return badge;
    }
}
