package seminar.sem7.factorymethod;

import seminar.sem7.simplefactory.*;

public class FactoryTemaUniversala extends FactoryAbstract{
    @Override
    public SuperErouAbstract getSuperErou(TipErou tip, String nume) {
        SuperErouAbstract supererou = null;
        switch(tip){
            case DISNEY:
                supererou = new CaracterDisney(nume,100,false);
                break;
            case DC:
                supererou = new CaracterDCComics(nume,500,50);
                break;
            case MARVEL:
                supererou = new CaracterMarvel(nume,250,0);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return supererou;
    }
}
