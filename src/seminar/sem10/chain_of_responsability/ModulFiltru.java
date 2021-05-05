package seminar.sem10.chain_of_responsability;

public class ModulFiltru extends HandlerChainAbstract {

    public ModulFiltru(String numeModul) {
        super(numeModul);
    }

    @Override
    public void procesareMesajChat(MesajChat mesaj) {
        String[] dictionar = new String[]{"rau", "obraznic", "violent"};
        boolean esteValid = true;
        for (String cuvant : dictionar) {
            if (mesaj.getContinut().contains(cuvant)) {
                esteValid = false;
                break;
            }
        }

        if (esteValid && this.next != null) {
            this.next.procesareMesajChat(mesaj);
        }
    }

}
