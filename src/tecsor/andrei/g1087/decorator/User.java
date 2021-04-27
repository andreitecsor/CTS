package tecsor.andrei.g1087.decorator;

public class User {
    private String username;
    private String displayName;
    private Double greenPoints;

    public User(String username, String displayName) {
        this.username = username;
        this.displayName = displayName;
        this.greenPoints = 0.0;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void increaseGreenPoints(Double greenPoints) {
        if (greenPoints > 0) {
            this.greenPoints += greenPoints;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
