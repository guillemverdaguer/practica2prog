package prog2.model;

public class Bungalow extends Casa {

    private int placesParking;
    private boolean terrassa;
    private boolean televisio;
    private boolean aireFred;

    public Bungalow(String nom, String id, boolean operatiu, String iluminacio,
                    float mida, int habitacions, int placesPersones,
                    int placesParking, boolean terrassa,
                    boolean televisio, boolean aireFred) {

        super(nom, id, operatiu, iluminacio, 4, 7,
                mida, habitacions, placesPersones);

        this.placesParking = placesParking;
        this.terrassa = terrassa;
        this.televisio = televisio;
        this.aireFred = aireFred;
    }


    public int getPlacesParking() {
        return placesParking;
    }

    public void setPlacesParking(int placesParking) {
        this.placesParking = placesParking;
    }

    public boolean isTerrassa() {
        return terrassa;
    }

    public void setTerrassa(boolean terrassa) {
        this.terrassa = terrassa;
    }

    public boolean isTelevisio() {
        return televisio;
    }

    public void setTelevisio(boolean televisio) {
        this.televisio = televisio;
    }

    public boolean isAireFred() {
        return aireFred;
    }

    public void setAireFred(boolean aireFred) {
        this.aireFred = aireFred;
    }

    @Override
    public boolean correcteFuncionament() {
        return aireFred;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Bungalow{" +
                "placesParking=" + placesParking +
                ", terrassa=" + terrassa +
                ", televisio=" + televisio +
                ", aireFred=" + aireFred +
                '}';
    }
}