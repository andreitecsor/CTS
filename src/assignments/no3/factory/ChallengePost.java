package assignments.no3.factory;

public class ChallengePost extends Post {
    private String challenge;

    public ChallengePost(Type type, String challenge) {
        super(type);
        this.challenge = challenge;
    }

    @Override
    public void showPost() {
        System.out.println(this.getCreatedAt() + " - User started the following challenge: " + challenge);
    }
}
