package seminar.sem7.factorymethod;


import seminar.sem7.simplefactory.SuperErouAbstract;
import seminar.sem7.simplefactory.TipErou;

public abstract class FactoryAbstract {

    public abstract SuperErouAbstract getSuperErou(TipErou tip, String nume);
}
