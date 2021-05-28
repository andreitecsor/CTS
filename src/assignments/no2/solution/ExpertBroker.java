package assignments.no2.solution;

import assignments.no2.solution.exception.ValoareIncorectaException;

public class ExpertBroker implements Broker {
    private Double taxaBroker;

    public ExpertBroker(Double taxaBroker) throws ValoareIncorectaException {
        if (taxaBroker < 0 || taxaBroker >= 100) {
            throw new ValoareIncorectaException("Taxa brokerului trebuie sa fie reprezentata in puncte procentuale.");
        }
        this.taxaBroker = taxaBroker;
    }

    @Override
    public double calculeazaTaxa() {
        return this.taxaBroker / 100;
    }

    @Override
    public boolean taxeazaContul(TipCont tipCont) {
        return tipCont == TipCont.PREMIUM || tipCont == TipCont.SUPER_PREMIUM;
    }

}
