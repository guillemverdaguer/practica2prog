package prog2.model;

public class BungalowPremium extends Bungalow {

    private boolean llencolsTovalloles;
    private String codiWifi;

    public BungalowPremium(String nom, String id, boolean operatiu, String iluminacio,
                           float mida, int habitacions, int placesPersones,
                           int placesParking, boolean terrassa,
                           boolean televisio, boolean aireFred,
                           boolean llencolsTovalloles, String codiWifi) {

        super(nom, id, operatiu, iluminacio, mida, habitacions, placesPersones, placesParking, terrassa, televisio, aireFred);

        this.llencolsTovalloles = llencolsTovalloles;
        this.codiWifi = codiWifi;
    }

    public boolean isLlencolsTovalloles() {
        return llencolsTovalloles;
    }

    public void setLlencolsTovalloles(boolean llencolsTovalloles) {
        this.llencolsTovalloles = llencolsTovalloles;
    }

    public String getCodiWifi() {
        return codiWifi;
    }

    public void setCodiWifi(String codiWifi) {
        this.codiWifi = codiWifi;
    }

    @Override
    public boolean correcteFuncionament() {

        boolean wifiValid = codiWifi != null &&
                codiWifi.length() >= 8 &&
                codiWifi.length() <= 16;

        return isAireFred() && wifiValid;
    }

    @Override
    public String toString() {
        return super.toString() +
                " BungalowPremium{" +
                "llencolsTovalloles=" + llencolsTovalloles +
                ", codiWifi='" + codiWifi + '\'' +
                '}';
    }
}