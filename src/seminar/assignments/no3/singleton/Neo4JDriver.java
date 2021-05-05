package seminar.assignments.no3.singleton;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Neo4JDriver that = (Neo4JDriver) o;

        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        return uri.equals(that.uri);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + uri.hashCode();
        return result;
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
