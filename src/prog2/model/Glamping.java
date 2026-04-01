package prog2.model;

public class Glamping extends Casa {

    private String tipus; // tela o fusta
    private boolean casaMascota;

    public Glamping(String nom, String id, boolean operatiu, String iluminacio,
                    long estadaMinimaALTA, long estadaMinimaBAIXA,
                    String mida, int habitacions, int placesPersones,
                    String tipus, boolean casaMascota) {

        super(nom, id, operatiu, iluminacio, estadaMinimaALTA, estadaMinimaBAIXA,
                mida, habitacions, placesPersones);

        this.tipus = tipus;
        this.casaMascota = casaMascota;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public boolean isCasaMascota() {
        return casaMascota;
    }

    public void setCasaMascota(boolean casaMascota) {
        this.casaMascota = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Glamping{" +
                "tipus='" + tipus + '\'' +
                ", casaMascota=" + casaMascota +
                '}';
    }
}