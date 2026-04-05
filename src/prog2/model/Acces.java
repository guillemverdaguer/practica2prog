package prog2.model;

public abstract class Acces implements InAcces {

    private String nom;
    private boolean obert;
    private LlistaAllotjaments allotjaments;

    public Acces(String nom, boolean obert) {
        this.nom = nom;
        this.obert = obert;
        this.allotjaments = new LlistaAllotjaments();
    }

    public void afegirAllotjament(Allotjament allotjament) throws prog2.vista.ExcepcioCamping {
        allotjaments.afegirAllotjament(allotjament);
    }

    public void tancarAcces() { obert = false; }

    public void obrirAcces() { obert = true; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public boolean isObert() { return obert; }

    public void setObert(boolean obert) { this.obert = obert; }

    public LlistaAllotjaments getAAllotjaments() { return allotjaments; }

    public abstract boolean isAccessibilitat();

    @Override
    public String toString() {
        return "Acces: nom = " + nom + ", obert = " + obert + ", allotjaments = " + allotjaments + '}';
    }
}