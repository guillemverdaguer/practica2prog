package prog2.model;

public class CarreteraAsfalt extends AccesAsfalt {

    private float pesMaxim;

    public CarreteraAsfalt(String nom, boolean obert, float metresQuadrats, float pesMaxim) {
        super(nom, obert, metresQuadrats);
        this.pesMaxim = pesMaxim;
    }

    public float getPesMaxim() { return pesMaxim; }

    public void setPesMaxim(float pesMaxim) { this.pesMaxim = pesMaxim; }

    @Override
    public boolean isAccessibilitat() { return true; }

    @Override
    public String toString() {
        return super.toString() + ", tipus=CarreteraAsfalt, metresQuadrats=" + metresQuadrats + ", pesMaxim=" + pesMaxim;
    }
}