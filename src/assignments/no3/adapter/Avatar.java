package assignments.no3.adapter;

import assignments.no3.decorator.User;

import java.util.HashMap;
import java.util.Map;

public class Avatar implements AvatarReactions {
    private User user;
    private Gender gender;
    private Map<String, String> attributes;

    public Avatar(User user, Gender gender) {
        this.user = user;
        this.gender = gender;
        this.attributes = new HashMap<>() {{
            put("hair", "standard");
            put("lips", "standard");
            put("eyes", "standard");
            put("ears", "standard");
        }};
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void smile() {
        System.out.println(user.getDisplayName() + ": (｡◕‿◕｡)");
    }

    @Override
    public void amazed() {
        System.out.println(user.getDisplayName() + ": ಠoಠ");
    }

    @Override
    public void wink() {
        System.out.println(user.getDisplayName() + " ಠ‿↼ ");

    }

}
