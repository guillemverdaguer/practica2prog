package prog2.model;

import java.util.ArrayList;
import prog2.vista.ExcepcioCamping;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {

    private ArrayList<TascaManteniment> tasquesManteniment;

    public LlistaTasquesManteniment() { this.tasquesManteniment = new ArrayList<>(); }

    public ArrayList<TascaManteniment> getTasquesManteniment() {
        return tasquesManteniment;
    }

    public void setTasquesManteniment(ArrayList<TascaManteniment> tasquesManteniment) {
        this.tasquesManteniment = tasquesManteniment;
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        for(TascaManteniment tascaManteniment: tasquesManteniment){
            if(tascaManteniment.getAllotjament().getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("Aquest allotjament ja té tasca");
            }
        }
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("No existeix la tasca: " + tipus);
        }
        TascaManteniment tascaManteniment = new TascaManteniment(num, tipus, allotjament, data, dies);
        tasquesManteniment.add(tascaManteniment);
        allotjament.tancarAllotjament(tascaManteniment);
    }


    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if(!tasquesManteniment.contains(tasca)){
            throw new ExcepcioCamping("Actualment aquest allotjament no té tasques de manteniment");
        }
        tasca.getAllotjament().obrirAllotjament();
        tasquesManteniment.remove(tasca);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (tasquesManteniment.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap tasca de manteniment");
        }
        String resultat = "";
        for (TascaManteniment tascaManteniment : tasquesManteniment) {
            resultat += tascaManteniment.toString() + "\n";
        }
        return resultat;
    }

    /**
     * Busca la tasca amb el número rebut per paràmetre i la retorna.
     * En cas que no existeixi llança una excepció.
     * @param num Número d'identificació de la tasca.
     * @return Objecte de tipus TascaManteniment
     * @throws ExcepcioCamping Aquest mètode llança una excepció si no existeix cap tasca amb el número passat per paràmetre.
     */

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        if (tasquesManteniment.isEmpty()) {
            throw new ExcepcioCamping("No hi ha cap tasca de manteniment");
        }
        for(TascaManteniment tascaManteniment: tasquesManteniment){
            if(tascaManteniment.getNum() == num){
                return tascaManteniment;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat aquesta tasca de manteniment amb numero: " + num);
    }
}
