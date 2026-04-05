package prog2.model;

public class CamiTerra extends AccesTerra {

    public CamiTerra(String nom, boolean obert, float longitud) {
        super(nom, obert, longitud);
    }

    @Override
    public boolean isAccessibilitat() { return false; }

    @Override
    public String toString() {
        return super.toString() + ", tipus = CamiTerra, longitud = " + longitud;
    }
}
