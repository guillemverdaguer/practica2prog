package prog2.model;

import java.util.ArrayList;

public abstract class AccesTerra extends Acces {

    protected float longitud;

    public AccesTerra(String nom, boolean obert, float longitud) {
        super(nom, obert);
        this.longitud = longitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) { this.longitud = longitud; }
}
