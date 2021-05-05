package seminar.assignments.no3.adapter;

public class Memoji implements AppleAvatarReactions {
    private boolean hasHat;
    private boolean hasFreckles;
    private Age age;

    public Memoji(boolean hasHat, boolean hasFreckles, Age age) {
        this.hasHat = hasHat;
        this.hasFreckles = hasFreckles;
        this.age = age;
    }

    @Override
    public String iHappy() {
        return "Happy memoji face";
    }

    @Override
    public String iWow() {
        return "Amazed memoji face";
    }

    @Override
    public String iWink() {
        return "Winking memoji face";
    }

    @Override
    public String iAmCool() {
        return "Indifferent memoji face";
    }
}
