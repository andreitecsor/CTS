package seminar.sem9.proxy;

public class TestProxy {
    public static void main(String[] args) {
        InterfataModulLogin login = new ModulLogin("10.0.0.1", 123);

        login = new ProxyLogin(login);

        if (login.login("admin", "admin123")) {
            System.out.println("Hello admin");
        }

        String[] parole = new String[]{"1234", "123456", "admin", "root", "admin123"};
        for (String parola : parole) {
            if (login.login("admin", parola)) {
                System.out.println("parola gasita:" + parola);
            }
        }

        System.out.println("Log out");
    }
}
