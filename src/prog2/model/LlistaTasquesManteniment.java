package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> tasquesManteniment;

    public LlistaTasquesManteniment() { this.tasquesManteniment = new ArrayList<>(); }


    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        for(TascaManteniment tascaManteniment: tasquesManteniment){
            if(tascaManteniment.getAllotjament().getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("Aquest allotjament ja te tasca");
            }
        }
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.VvalueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("No existeix la tasca: " + tipus);
        }
        TascaManteniment tascaManteniment = new TascaManteniment(num, tipus, allotjament, data, dies);
        tasquesManteniment.add(tascaManteniment);
        Allotjament.
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {

    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return "";
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        return null;
    }

    public ArrayList<TascaManteniment> getTasquesManteniment() {
        return tasquesManteniment;
    }

    public void setTasquesManteniment(ArrayList<TascaManteniment> tasquesManteniment) {
        this.tasquesManteniment = tasquesManteniment;
    }
}
