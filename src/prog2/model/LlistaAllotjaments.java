package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments{

    private ArrayList<Allotjament> allotjaments;

    public LlistaAllotjaments() { this.allotjaments = new ArrayList<>(); }

    public ArrayList<Allotjament> getAllotjaments() { return allotjaments; }

    public void setAllotjaments(ArrayList<Allotjament> allotjaments) { this.allotjaments = allotjaments; }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        for(Allotjament allotjament1 : allotjaments){
            if(allotjament1.getId().equals(allotjament.getId())){
                throw new ExcepcioCamping("Aquest allotjament ja esta a la llista");
            }
        }
        allotjaments.add(allotjament);
    }

    @Override
    public void buidar() {
        allotjaments.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        if (allotjaments.isEmpty()) {
            throw new ExcepcioCamping("No hi ha allotjaments");
        }
        String resultat = "";
        for (Allotjament allotjament : allotjaments) {
            if (allotjament.isOperatiu() && estat.equals("operatiu")) {
                resultat += allotjament.toString() + "\n";
            } else if (!allotjament.isOperatiu() && estat.equals("no operatiu")) {
                resultat += allotjament.toString() + "\n";
            }
        }

        if (resultat.length() == 0) {
            throw new ExcepcioCamping("No hi ha cap allotjament amb aquest estat");
        }
        return resultat;
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        for(Allotjament allotjament :  allotjaments){
            if(allotjament.isOperatiu()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        for(Allotjament allotjament1 : allotjaments){
            if(allotjament1.getId().equals(allotjament.getId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        if(allotjaments.isEmpty()){
            throw new ExcepcioCamping("No hi ha allotjaments");
        }
        for(Allotjament allotjament : allotjaments){
            if(allotjament.getId().equals(id)){
                return allotjament;
            }
        }
        throw new ExcepcioCamping("No s'ha trobat aquest allotjament");
    }
}
