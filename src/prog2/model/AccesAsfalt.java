package prog2.model;

public abstract class AccesAsfalt extends Acces {

    protected float metresQuadrats;

    public AccesAsfalt(String nom, boolean obert, float metresQuadrats) {
        super(nom, obert);
        this.metresQuadrats = metresQuadrats;
    }

    public float getMetresQuadrats() {
        return metresQuadrats;
    }

    public void setMetresQuadrats(float metresQuadrats) {
        this.metresQuadrats = metresQuadrats;
    }
}
