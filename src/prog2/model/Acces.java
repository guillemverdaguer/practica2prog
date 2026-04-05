package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {

    protected String nom;
    protected boolean obert;
    protected ArrayList<Allotjament> allotjaments;

    public Acces(String nom, boolean obert) {
        this.nom = nom;
        this.obert = obert;
        this.allotjaments = new ArrayList<>();
    }

    public void afegirAllotjament(Allotjament allotjament) {
        allotjaments.add(allotjament);
    }

    public void tancarAcces() { obert = false; }

    public void obrirAcces() { obert = true; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public boolean isObert() { return obert; }

    public void setObert(boolean obert) { this.obert = obert; }

    public ArrayList<Allotjament> getAllotjaments() { return allotjaments; }

    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Acces{nom='" + nom + "', obert=" + obert + ", allotjaments=" + allotjaments + '}';
    }
}