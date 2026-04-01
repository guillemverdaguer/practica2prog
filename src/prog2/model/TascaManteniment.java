package prog2.model;

public class TascaManteniment implements InTascaManteniment {


    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
    private int numero;
    private Allotjament allotjament;
    private TipusTascaManteniment tipus;
    private String data;
    private int dies;

    public TascaManteniment(int numero, Allotjament allotjament, TipusTascaManteniment tipus, String data, int dies) {
        this.numero = numero;
        this.allotjament = allotjament;
        this.tipus = tipus;
        this.data = data;
        this.dies = dies;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public TipusTascaManteniment getTipus() {
        return tipus;
    }

    public void setTipus(TipusTascaManteniment tipus) {
        this.tipus = tipus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDies() {
        return dies;
    }

    public void setDies(int dies) {
        this.dies = dies;
    }

    public String getIluminacioAllotjament() {
         if(tipus == TipusTascaManteniment.Reparacio) {
             return "50%";
         }
         else if(tipus == TipusTascaManteniment.Neteja) {
             return "100%";
         }
         else if(tipus  == TipusTascaManteniment.RevisioTecnica) {
             return "50%";
         }
         else if(tipus == TipusTascaManteniment.Desinfeccio) {
             return "0%";
         }

        }
    }


}
