package prog2.model;

public abstract class Casa extends Allotjament {

    private float mida;
    private int habitacions;
    private int placesPersones;

    public Casa(String nom, String id, boolean operatiu, String iluminacio, long estadaMinimaALTA, long estadaMinimaBAIXA,
                float mida, int habitacions, int placesPersones) {

        super(nom, id, operatiu, iluminacio, estadaMinimaALTA, estadaMinimaBAIXA);

        this.mida = mida;
        this.habitacions = habitacions;
        this.placesPersones = placesPersones;
    }

    public float getMida() {
        return mida;
    }

    public void setMida(float mida) {
        this.mida = mida;
    }

    public int getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(int habitacions) {
        this.habitacions = habitacions;
    }

    public int getPlacesPersones() {
        return placesPersones;
    }

    public void setPlacesPersones(int placesPersones) {
        this.placesPersones = placesPersones;
    }

    @Override
    public String toString() {
        return super.getNom() + " (" + super.getId() + ") " +
                "Casa{" +
                "mida='" + mida + '\'' +
                ", habitacions=" + habitacions +
                ", placesPersones=" + placesPersones +
                '}';
    }
}
