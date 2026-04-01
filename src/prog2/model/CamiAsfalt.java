package prog2.model;

import java.util.ArrayList;

public class CamiAsfalt extends AccesAsfalt {

    public CamiAsfalt(String nom, boolean obert, ArrayList<String> allotjaments, double metresQuadrats) {
        super(nom, obert, allotjaments, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() {
        return false; // camí asfaltat → no vehicles
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipus=CamiAsfalt, metresQuadrats=" + metresQuadrats;
    }
}
