package prog2.model;

import java.util.ArrayList;
import prog2.vista.ExcepcioCamping;

public class LlistaAccessos implements InLlistaAccessos {

    private ArrayList<Acces> accessos;

    public LlistaAccessos() { this.accessos = new ArrayList<>(); }

    public ArrayList<Acces> getAccessos() {
        return accessos;
    }

    public void setAccessos(ArrayList<Acces> accessos) {
        this.accessos = accessos;
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        for(Acces acces : accessos){
            if(acces.getNom().equals(acc.getNom())) {
                throw new ExcepcioCamping("Aquest acces ja esta a la llista");
            }
        }
        accessos.add(acc);
    }

    @Override
    public void buidar() {
        accessos.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha accessos");
        }
        String resultat = "";
        for(Acces acces : accessos){
            if(acces.isObert() == estat){
                resultat += acces.toString() + "\n";
            }
        }
        if(resultat.length() == 0){
            throw new ExcepcioCamping("No hi ha cap acces en aquest estat");
        }
        return resultat;
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces acces : accessos) {
            acces.setObert(false);
            for (Allotjament allotjament : acces.getAllotjaments()) {
                if (allotjament.isOperatiu()) {
                    acces.setObert(true);
                }
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha accessos");
        }
        int comptador = 0;
        for(Acces acces : accessos){
            if(!acces.isAccessibilitat()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        if(accessos.isEmpty()){
            throw new ExcepcioCamping("No hi ha accessos");
        }
        float comptador = 0;
        for(Acces acces : accessos){
            if(acces instanceof AccesTerra){
                comptador += ((AccesTerra) acces).getLongitud();

            }
        }
        return comptador;
    }
}
