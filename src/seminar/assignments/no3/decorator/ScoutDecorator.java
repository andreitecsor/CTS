package seminar.assignments.no3.decorator;

public class ScoutDecorator extends ProfileDecorator {
    private Boolean acceptFullTheme;

    public ScoutDecorator(Profile profile, boolean applyFullTheme) {
        super(profile);
        this.acceptFullTheme = applyFullTheme;
        super.setMainTheme(MainTheme.GREEN_SCOUT);
    }

    @Override
    public void showProfile() {
        if (acceptFullTheme) {
            System.out.println(super.getDisplayName() + "-> FULL SCOUT PROFILE");
        } else {
            System.out.println(super.getDisplayName() + "-> CUSTOM SCOUT PROFILE");
        }
    }
}
