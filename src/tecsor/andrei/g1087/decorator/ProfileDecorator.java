package tecsor.andrei.g1087.decorator;

public abstract class ProfileDecorator implements Profile {
    private Profile profile = null;

    public ProfileDecorator(Profile profile) {
        this.profile = profile;
    }

    @Override
    public User getUser() {
        return this.profile.getUser();
    }

    public MainTheme getMainTheme() {
        return profile.getMainTheme();
    }

    @Override
    public String getDisplayName() {
        return profile.getDisplayName();
    }

    @Override
    public void setMainTheme(MainTheme profileMainTheme) {
        profile.setMainTheme(profileMainTheme);
    }
}
