package tecsor.andrei.g1087.factory;

public class FactoryPost {

    public static Post getPostType(Type type, String specificPostDetail) {
        Post post = null;
        switch (type) {
            case CHALLENGE:
                post = new ChallengePost(type, specificPostDetail);
                break;
            case AWARD:
                post = new AwardPost(type, specificPostDetail);
                break;
            case MILESTONE:
                post = new MilestonePost(type, specificPostDetail);
                break;
            case FOLLOW:
                post = new FollowPost(type, specificPostDetail);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return post;
    }
}
