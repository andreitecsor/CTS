package seminar.assignments.no3.decorator;

public interface Profile {
    String getDisplayName();

    User getUser();

    MainTheme getMainTheme();

    void setMainTheme(MainTheme profileMainTheme);

    void showProfile();
}
