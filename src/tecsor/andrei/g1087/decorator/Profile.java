package tecsor.andrei.g1087.decorator;

public interface Profile {
    String getDisplayName();

    User getUser();

    MainTheme getMainTheme();

    void setMainTheme(MainTheme profileMainTheme);

    void showProfile();
}
