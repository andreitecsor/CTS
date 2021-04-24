package tecsor.andrei.g1087.singleton;

public class Neo4JDriver {
    private String username;
    private String password;
    private String uri;

    public Neo4JDriver(String username, String password, String uri) {
        this.username = username;
        this.password = password;
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Neo4JDriver{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
