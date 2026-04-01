package prog2.model;

import java.util.ArrayList;

public class CarreteraTerra extends AccesTerra {

    private double amplada;

    public CarreteraTerra(String nom, boolean obert, ArrayList<String> allotjaments,
                          double longitud, double amplada) {
        super(nom, obert, allotjaments, longitud);
        this.amplada = amplada;
    }

    public double getAmplada() {
        return amplada;
    }

    public void setAmplada(double amplada) {
        this.amplada = amplada;
    }

    @Override
    public boolean isAccessibilitat() {
        return true; // carretera de tierra → sí vehículos
    }

    @Override
    public String toString() {
        return super.toString() +
                ", tipus=CarreteraTerra, longitud=" + longitud +
                ", amplada=" + amplada;
    }
}
