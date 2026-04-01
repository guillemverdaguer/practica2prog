package prog2.model;

import java.util.ArrayList;

public class CarreteraAsfalt extends AccesAsfalt {

    private double pesMaxim;

    public CarreteraAsfalt(String nom, boolean obert, ArrayList<String> allotjaments,
                           double metresQuadrats, double pesMaxim) {
        super(nom, obert, allotjaments, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    public double getPesMaxim() {
        return pesMaxim;
    }

    public void setPesMaxim(double pesMaxim) {
        this.pesMaxim = pesMaxim;
    }

    @Override
    public boolean isAccessibilitat() {
        return true; // carretera asfaltada → sí vehículos
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipus=CarreteraAsfalt, metresQuadrats=" + metresQuadrats +
                ", pesMaxim=" + pesMaxim;
    }
}