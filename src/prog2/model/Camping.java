package prog2.model;

import prog2.vista.ExcepcioCamping;

import java.time.LocalDate;
import java.util.ArrayList;

public class Camping implements InCamping {

    private String nomCamping;
    private LlistaAllotjaments llistaAllotjaments;
    private LlistaAccessos llistaAccessos;
    private LlistaTasquesManteniment llistaTasquesManteniment;
    //private ArrayList<Client> llistaClients;
    //private LlistaReserves llistaReserves;

    public Camping(String nomCamping) {

        this.nomCamping = nomCamping;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaTasquesManteniment = new LlistaTasquesManteniment();
        this.llistaAccessos = new LlistaAccessos();
        //this.llistaClients = new ArrayList<>();
        // this.llistaReserves = new LlistaReserves();
    }

    @Override
    public String getNomCamping() {
        return nomCamping;
    }

    public String llistarAllotjaments(String estat) throws ExcepcioCamping{
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    public String llistarAccessos(String infoEstat) throws ExcepcioCamping{
        if(!infoEstat.equals("Obert") & !infoEstat.equals("Tancat")){
            throw new ExcepcioCamping("No existeix aquest estat");
        }
        if(infoEstat.equals("Obert")){
            return llistaAccessos.llistarAccessos(true);
        }
        else{
            return llistaAccessos.llistarAccessos(false);
        }
    }

    public String llistarTasquesManteniment() throws ExcepcioCamping{
        return llistaTasquesManteniment.llistarTasquesManteniment();
    }

    public void afegirTascaManteniment(int num, String tipus, String idAllotjament,
                                       String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasquesManteniment.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    public void completarTascaManteniment(int num) throws ExcepcioCamping{
        TascaManteniment tascaManteniment = llistaTasquesManteniment.getTascaManteniment(num);

    }


    @Override
    public void afegirParcela(String nom, String id, float metres, boolean connexioElectrica) {

        Parcela parcela = new Parcela(nom, id, metres, connexioElectrica);
        llistaAllotjaments.add(parcela);

    }

    @Override
    public void afegirBungalow(String nom, String id, String mida, int habitacions,
                               int placesPersones, int placesParking,
                               boolean terrassa, boolean televisio, boolean aireFred) {

        Bungalow bungalow = new Bungalow(nom, id, 4, 7,
                mida, habitacions, placesPersones,
                placesParking, terrassa, televisio, aireFred);

        llistaAllotjaments.add(bungalow);
    }

    @Override
    public void afegirBungalowPremium(String nom, String id, String mida, int habitacions,
                                      int placesPersones, int placesParking,
                                      boolean terrassa, boolean televisio,
                                      boolean aireFred, boolean llencols,
                                      String wifi) {

        BungalowPremium bungalowPremium = new BungalowPremium(nom, id, 4, 7, mida, habitacions, placesPersones,
                placesParking, terrassa, televisio, aireFred, llencols, wifi);
        llistaAllotjaments.add(bungalowPremium);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, boolean codiWifi) {

    }

    @Override
    public void afegirGlamping(String nom, String id, String mida, int habitacions,
                               int placesPersones, String tipus, boolean casaMascota) {

        Glamping glamping = new Glamping(nom, id, 3, 3,
                mida, habitacions, placesPersones,
                tipus, casaMascota);

        llistaAllotjaments.add(glamping);
    }

    @Override
    public void afegirMobilHome(String nom, String id, String mida, int habitacions,
                                int placesPersones, boolean terrassaBarbacoa) {

        MobilHome mobilHome = new MobilHome(nom, id, 3, 5,
                mida, habitacions, placesPersones,
                terrassaBarbacoa);

        llistaAllotjaments.add(mobilHome);
    }

    private Allotjament buscarAllotjament(String id) {

        for (Allotjament allotjament : llistaAllotjaments) {

            if (allotjament.getId().equals(id)) {
                return allotjament;
            }
        }

        return null;
    }



    @Override
    public LlistaAllotjaments getLlistaAllotjaments() {
        return llistaAllotjaments;
    }

    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments.size();
    }

    public LlistaAccessos getLlistaAccessos() {
        return llistaAccessos;
    }

    public void setLlistaAccessos(LlistaAccessos llistaAccessos) {
        this.llistaAccessos = llistaAccessos;
    }

    public LlistaTasquesManteniment getLlistaTasquesManteniment() {
        return llistaTasquesManteniment;
    }

    public void setLlistaTasquesManteniment(LlistaTasquesManteniment llistaTasquesManteniment) {
        this.llistaTasquesManteniment = llistaTasquesManteniment;
    }

    //METODES DE LA P1 NO NECESSARIS
    /*
    private Client buscarClient(String dni) {

        for (Client client : llistaClients) {

            if (client.getDni().equals(dni)) {
                return client;
            }
        }

        return null;
    }

    @Override
    public void afegirClient(String nom, String dni) {

        Client client = new Client(nom, dni);
        llistaClients.add(client);
    }

    @Override
    public void afegirReserva(String id, String dni,
                              LocalDate dataEntrada,
                              LocalDate dataSortida) throws ExcepcioReserva {

        Allotjament allotjament = buscarAllotjament(id);
        Client client = buscarClient(dni);

        if (allotjament == null) {
            throw new ExcepcioReserva("L'allotjament amb id " + id + " no existeix");
        }
        if (client == null) {
            throw new ExcepcioReserva("El client amb DNI "+ dni + " no existeix");
        }

        llistaReserves.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients;
    }

    @Override
    public int getNumReserves() {
        return llistaReserves.getReserves().size();
    }

    @Override
    public int getNumClients() {
        return llistaClients.size();
    }

    @Override
    public LlistaReserves getLlistaReserves() {
        return llistaReserves;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        if (llistaAllotjaments.isEmpty()) {
            return null;
        }
        Allotjament millor = llistaAllotjaments.get(0);
        for (Allotjament allotjament : llistaAllotjaments) {
            if (allotjament.getEstadaMinima(temp) < millor.getEstadaMinima(temp)) {
                millor = allotjament;
            }
        }
        return millor;
    }

    public static InAllotjament.Temp getTemporada(LocalDate data) {

        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();

        if ((mes > 3 && mes < 9) ||
                (mes == 3 && dia >= 21) ||
                (mes == 9 && dia <= 20)) {

            return InAllotjament.Temp.ALTA;
        }

        return InAllotjament.Temp.BAIXA;
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        for (Allotjament a : llistaAllotjaments) {
            if (a.correcteFuncionament()) {
                comptador++;
            }
        }
        return comptador;
    }
     @Override
    public int getNumAllotjamentsOperatius() {

        int comptador = 0;

        for (Allotjament allotjament : llistaAllotjaments) {

            if (allotjament.correcteFuncionament()) {
                comptador++;
            }
        }

        return comptador;
    }
     */

}