package prog2.model;

import java.util.ArrayList;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean obert, ArrayList<String> allotjaments, double longitud) {
        super(nom, obert, allotjaments, longitud);
    }

    @Override
    public boolean isAccessibilitat() {
        return false; // camí de terra → no vehículos
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipus=CamiTerra, longitud=" + longitud;
    }
}
