package assignments.no2.solution;

import assignments.no2.solution.exception.CalculInvalidException;
import assignments.no2.solution.exception.ValoareIncorectaException;

import java.util.List;

public class Cont implements NecesarCont {
    private Double valoareImprumut;
    private Double rata;
    private Integer zileActiv;
    private TipCont tipCont;
    private Broker broker;

    public static final Integer ZILE_AN = 365;

    public Cont(Double valoareImprumut, Double rata, TipCont tipCont, Broker broker) throws ValoareIncorectaException {
        if (valoareImprumut < 0) {
            throw new ValoareIncorectaException("Valoarea imprumutului nu poate fi negativa");
        }
        if (rata < 0) {
            throw new ValoareIncorectaException("Rata nu poate fi negativa");
        }
        this.valoareImprumut = valoareImprumut;
        this.rata = rata;
        this.tipCont = tipCont;
        this.broker = broker;
        this.zileActiv = 0;
    }

    public double getValoareImprumut() {
        return this.valoareImprumut;
    }

    public double getRata() {
        return this.rata;
    }

    public TipCont getTipCont() {
        return tipCont;
    }

    public int getZileActiv() {
        return this.zileActiv;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setValoareImprumut(Double valoare) throws ValoareIncorectaException {
        if (valoare < 0) {
            throw new ValoareIncorectaException("Valoarea imprumutului nu poate fi negativa");
        }
        this.valoareImprumut = valoare;
    }

    public void setZileActiv(Integer zileActiv) throws ValoareIncorectaException {
        if (zileActiv <= 0) {
            throw new ValoareIncorectaException("Zilele de activitate trebuie sa fie mai mari decat 0");
        }
        this.zileActiv = zileActiv;
    }

    public double calculeazaDobandaPrincipala() {
        return this.valoareImprumut
                * Math.pow(this.rata, (this.zileActiv / ZILE_AN)) - this.valoareImprumut;
    }

    @Override
    public double getRataLunara() {
        return this.valoareImprumut * this.rata;
    }

    @Override
    public String toString() {
        return "Loan: " + this.valoareImprumut +
                "; rate: " + this.rata +
                "; days active:" + this.zileActiv +
                "; Account type: " + this.tipCont + ";";
    }

    public static double calculeazaComisionTotalBrokeri(List<Cont> conturi) {
        double comisionTotal = 0.0;
        for (Cont cont : conturi) {
            if (cont == null) {
                throw new NullPointerException();
            }
            if (cont.getBroker().taxeazaContul(cont.getTipCont())) {
                if (cont.getZileActiv() <= 0) {
                    throw new CalculInvalidException("Contul trebuie sa aiba minim o zi activa");
                }
                comisionTotal += cont.getBroker().calculeazaTaxa() * cont.calculeazaDobandaPrincipala();
            }
        }
        return comisionTotal;
    }

}
