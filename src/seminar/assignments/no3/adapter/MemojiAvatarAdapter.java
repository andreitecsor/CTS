package seminar.assignments.no3.adapter;

import seminar.assignments.no3.decorator.User;

public class MemojiAvatarAdapter implements AvatarReactions {
    private User user;
    private AppleAvatarReactions memoji = null;

    public MemojiAvatarAdapter(User user, AppleAvatarReactions memoji) {
        this.user = user;
        this.memoji = memoji;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void smile() {
        System.out.println(user.getDisplayName() + " " + this.memoji.iHappy());
    }

    @Override
    public void amazed() {
        System.out.println(user.getDisplayName() + " " + this.memoji.iWow());
    }

    @Override
    public void wink() {
        System.out.println(user.getDisplayName() + " " + this.memoji.iWink());
    }
}
