package prog2.model;

import java.time.LocalDate;
import java.lang.String;

public abstract class Allotjament implements InAllotjament {
    public enum Temp {
        ALTA,
        BAIXA
    }

    private String nom;
    private String id;
    private long estadaMinimaALTA;
    private long estadaMinimaBAIXA;
    private boolean operatiu;
    private String iluminacio;


    public Allotjament(String nom, String id, boolean operatiu, String iluminacio,
                       long estadaMinimaALTA, long estadaMinimaBAIXA) {
        this.nom = nom;
        this.id = id;
        this.estadaMinimaALTA = estadaMinimaALTA;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA;
        this.operatiu = operatiu;
        this.iluminacio = iluminacio;
    }

    public static Temp getTemporada(LocalDate data) {

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        if ((mes > 3 && mes < 9) ||
                (mes == 3 && dia >= 21) ||
                (mes == 9 && dia <= 20)) {

            return Temp.ALTA;
        } else {
            return Temp.BAIXA;
        }
    }

    // getters y setters

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {

        if (temp == Temp.ALTA) {
            return estadaMinimaALTA;
        } else {
            return estadaMinimaBAIXA;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA = estadaMinimaALTA_;
        this.estadaMinimaBAIXA = estadaMinimaBAIXA_;
    }

    public boolean isOperatiu() {
        return operatiu;
    }

    public void setOperatiu(boolean operatiu) {
        this.operatiu = operatiu;
    }

    public String getIluminacio() {
        return iluminacio;
    }

    public void setIluminacio(String iluminacio) {
        this.iluminacio = iluminacio;
    }

    @Override
    public abstract boolean correcteFuncionament();

    public void tancarAllotjament(TascaManteniment tasca){
        this.setOperatiu(false);
        this.setIluminacio(tasca.getIluminacioAllotjament());
    }

    @Override
    public void obrirAllotjament(){
        this.setOperatiu(true);
        this.setIluminacio("100");
    }

    @Override
    public String toString() {
        return "Nom=" + getNom() + ", Id=" + getId() +
                ", estada mínima en temp ALTA: " + getEstadaMinima(Temp.ALTA) +
                ", estada mínima en temp BAIXA: " + getEstadaMinima(Temp.BAIXA) + ".";
    }


}