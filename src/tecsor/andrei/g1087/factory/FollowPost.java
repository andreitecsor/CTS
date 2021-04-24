package tecsor.andrei.g1087.factory;

public class FollowPost extends Post {
    private String followedUserName;

    public FollowPost(Type type, String followedUserName) {
        super(type);
        this.followedUserName = followedUserName;
    }

    @Override
    public void showPost() {
        System.out.println(this.getCreatedAt() + " - User started following: " + followedUserName);

    }
}
