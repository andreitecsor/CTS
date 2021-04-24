package tecsor.andrei.g1087.factory;

public class AwardPost extends Post {
    private String award;

    public AwardPost(Type type, String award) {
        super(type);
        this.award = award;
    }

    @Override
    public void showPost() {
        System.out.println(this.getCreatedAt() + " - User achieved the following award: " + award);
    }
}
