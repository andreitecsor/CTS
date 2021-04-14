package seminar.sem8.adapter;

public class AdaptorDisneyLaAcme extends ACMECaracterJoc {

    ActiuniDisney caracterDisney = null;

    public AdaptorDisneyLaAcme(ActiuniDisney caracterDisney) {
        super(caracterDisney.getNume(), caracterDisney.getPower());
        this.caracterDisney = caracterDisney;
    }

    @Override
    public void seDeplaseaza() {
        caracterDisney.move(0, 0);
    }

    @Override
    public void esteLovit(int puncte) {
        caracterDisney.primesteLovitura(puncte);
    }

    @Override
    public void seVindeca(int puncte) {
        caracterDisney.reincarca(puncte);
    }
}
