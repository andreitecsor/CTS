package seminar.sem8.facade;

public class APIJobFacade {

    public static ProfilJucator getProfil(String ipServer, int port, String numeUtilizator, String parola) {
        ServerJoc server = new ServerJoc(ipServer, port);
        if (server.conectare()) {
            Utilizator utilizator = new Utilizator();
            utilizator.login(numeUtilizator, parola);
            ProfilJucator profil = utilizator.getProfil();
            String dateProfil = profil.getDateProfil();
            return profil;
        }

        return null;
    }
}
