package prog2.model;

public class TascaManteniment implements InTascaManteniment {
    public static enum TipusTascaManteniment{
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    };
    private int num;
    private TipusTascaManteniment tipus;
    private Allotjament allotjament;
    private String data;
    private int dies;

    public TascaManteniment(int num, TipusTascaManteniment tipus, Allotjament allotjament, String data, int dies) {
        this.num = num;
        this.tipus = tipus;
        this.allotjament = allotjament;
        this.data = data;
        this.dies = dies;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public TipusTascaManteniment getTipus() {
        return tipus;
    }

    public void setTipus(TipusTascaManteniment tipus) {
        this.tipus = tipus;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
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

    public String getIluminacioAllotjament( ) {
         if(tipus == TipusTascaManteniment.Reparacio) {
             return "50%";
         }
         else if(tipus == TipusTascaManteniment.Neteja) {
             return "100%";
         }
         else if(tipus  == TipusTascaManteniment.RevisioTecnica) {
             return "50%";
         }
         else{
             return "0%";
         }
    }

    @Override
    public String toString() {
        return "Tasca: " + tipus + ", numero: " + num + ", id del allotjament: " + allotjament.getId();
    }


}
