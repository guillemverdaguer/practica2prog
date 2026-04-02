package prog2.model;

import java.util.ArrayList;

public abstract class AccesTerra extends Acces {

    protected double longitud;

    public AccesTerra(String nom, boolean obert, ArrayList<String> allotjaments, double longitud) {
        super(nom, obert, allotjaments);
        this.longitud = longitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) { this.longitud = longitud; }
}
