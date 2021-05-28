package assignments.no3.decorator;

public class ProfileImpl implements Profile {
    private User user;
    private MainTheme theme;

    public ProfileImpl(User user) {
        this.user = user;
        this.theme = MainTheme.TREE;
    }

    @Override
    public MainTheme getMainTheme() {
        return this.theme;
    }

    @Override
    public String getDisplayName() {
        return this.user.getDisplayName();
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void setMainTheme(MainTheme profileMainTheme) {
        this.theme = profileMainTheme;
    }

    @Override
    public void showProfile() {
        System.out.println(user.getDisplayName() + "-> BASIC PROFILE");
    }

    @Override
    public String toString() {
        return "ProfileImpl{" +
                "user=" + user +
                ", rank=" + theme +
                '}';
    }
}
