package prog2.model;

import java.util.ArrayList;

public abstract class AccesAsfalt extends Acces {

    protected double metresQuadrats;

    public AccesAsfalt(String nom, boolean obert, ArrayList<String> allotjaments, double metresQuadrats) {
        super(nom, obert, allotjaments);
        this.metresQuadrats = metresQuadrats;
    }

    public double getMetresQuadrats() {
        return metresQuadrats;
    }
}
