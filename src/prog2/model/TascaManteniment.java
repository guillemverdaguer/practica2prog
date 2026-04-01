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
    private String data;
    private int dies;

    public TascaManteniment(int numero, Allotjament allotjament, TipusTascaManteniment, String data, int dies) {
        this.numero = numero;
        this.allotjament = allotjament;
        this.data = data;
        this
    }
}
