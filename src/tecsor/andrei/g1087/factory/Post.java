package tecsor.andrei.g1087.factory;

import java.time.LocalDateTime;

public abstract class Post {
    private LocalDateTime createdAt;
    private Type type;

    public Post(Type type) {
        this.createdAt = LocalDateTime.now();
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Type getType() {
        return type;
    }

    public abstract void showPost();
}
