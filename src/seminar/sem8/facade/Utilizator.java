package seminar.sem8.facade;

public class Utilizator {
    public void  login(String username, String password){
        System.out.println("Login");
    }

    public ProfilJucator getProfil(){
        return new ProfilJucator();
    }
}
