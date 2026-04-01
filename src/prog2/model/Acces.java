package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {

    protected String nom;
    protected boolean obert;
    protected ArrayList<String> allotjaments;

    public Acces(String nom, boolean obert, ArrayList<String> allotjaments) {
        this.nom = nom;
        this.obert = obert;
        this.allotjaments = allotjaments;
    }

    // GETTERS & SETTERS
    public String getNom() {
        return nom;
    }

    public boolean isObert() {
        return obert;
    }

    public void setObert(boolean obert) {
        this.obert = obert;
    }

    public ArrayList<String> getAllotjaments() {
        return allotjaments;
    }

    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Acces{" +
                "nom='" + nom + '\'' +
                ", obert=" + obert +
                ", allotjaments=" + allotjaments +
                '}';
    }
}