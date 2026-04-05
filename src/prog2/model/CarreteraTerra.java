package prog2.model;

public class CarreteraTerra extends AccesTerra {

    private float amplada;

    public CarreteraTerra(String nom, boolean obert, float longitud, float amplada) {
        super(nom, obert, longitud);
        this.amplada = amplada;
    }

    public float getAmplada() { return amplada; }

    public void setAmplada(float amplada) { this.amplada = amplada; }

    @Override
    public boolean isAccessibilitat() { return true; }

    @Override
    public String toString() {
        return super.toString() + ", tipus=CarreteraTerra, longitud=" + longitud + ", amplada=" + amplada;
    }
}
