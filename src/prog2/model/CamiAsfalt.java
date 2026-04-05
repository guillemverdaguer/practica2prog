package prog2.model;

public class CamiAsfalt extends AccesAsfalt {

    public CamiAsfalt(String nom, boolean obert, float metresQuadrats) {
        super(nom, obert, metresQuadrats);
    }

    @Override
    public boolean isAccessibilitat() { return false; }

    @Override
    public String toString() {
        return super.toString() +
                ", tipus = CamiAsfalt, metresQuadrats =" + metresQuadrats;
    }
}
