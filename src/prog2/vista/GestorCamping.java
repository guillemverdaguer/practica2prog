package prog2.vista;

import prog2.model.Camping;
import prog2.model.Allotjament;
import prog2.model.InAllotjament;

import java.time.LocalDate;


/**
 * Classe per gestionar els allotjaments del Càmping del Mar.
 * @author lauraigual
 */
public class GestorCamping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Camping campingMar = new Camping("Camping del Mar");

        omplirDadesModel(campingMar);

        ferReserves(campingMar);


        // Mostrar el número total d'allotjaments del Càmping i el número d'allotjaments que estan operatius
        int totalAllotjaments = campingMar.getNumAllotjaments();
        int operatius = campingMar.getNumAllotjamentsOperatius();

        System.out.println(">> El número total d'allotjaments del Càmping és "
                + totalAllotjaments + " dels quals "
                + operatius + " allotjaments estan operatius.");


        // Mostrar l'allotjament amb estada mínima de la temporada alta més curta
        Allotjament allotjamentMesCurt =
                campingMar.getAllotjamentEstadaMesCurta(InAllotjament.Temp.ALTA);

        System.out.println(">> L'allotjament amb estada mínima de la temporada alta més curta és el següent:");
        System.out.println(allotjamentMesCurt);

    }

    /**
     * Mètode de classe per afegir parcel·les, bungalows, bungalows premium, glampings, mobil-home i clients al càmping.
     * @param camping L'objecte de tipus Camping que anem a omplir
     */
    private static void omplirDadesModel(Camping camping){


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "100P";

        float metres = 64.0f;
        boolean connexioElectrica = true;

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);

        nom = "Parcel·la Sud";
        idAllotjament = "101P";

        camping.afegirParcela(nom, idAllotjament, metres, connexioElectrica);


        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Est";
        idAllotjament = "102B";
        String mida = "Mitjana";

        int habitacions =2;
        int placesPersones = 6;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv = true;
        boolean aireFred = true;


        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        nom = "Bungalow Oest";
        idAllotjament = "103B";
        habitacions =2;
        placesPersones = 4;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = true;

        camping.afegirBungalow(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Nord";
        idAllotjament = "104BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 2;
        terrassa = true;
        tv= false;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        nom = "Bungallow Sud";
        idAllotjament = "105BP";
        mida = "Gran";
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= false;
        aireFred = false;
        serveisExtra = true;
        codiWifi = "CampingDelMarBP2";

        camping.afegirBungalowPremium(nom, idAllotjament, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);


        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "106G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        nom = "Glamping Sud";
        idAllotjament = "107G";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        material = "Tela";
        casaMascota = false;

        camping.afegirGlamping(nom, idAllotjament, mida, habitacions, placesPersones, material, casaMascota);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Nord";
        idAllotjament = "108MH";
        mida = "Petita";
        habitacions =1;
        placesPersones = 2;
        boolean terrassaBarbacoa = true;


        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);

        nom = "Mobil-Home Sud";
        idAllotjament = "109MH";
        mida = "Mitjana";
        habitacions =2;
        placesPersones = 4;
        terrassaBarbacoa = false;

        camping.afegirMobilHome(nom, idAllotjament, mida, habitacions, placesPersones, terrassaBarbacoa);


        // Afegir clients:
        //------------------------------

        String nomClient="Patricia Fernandez";
        String dni="12345678X";
        camping.afegirClient(nomClient, dni);

        nomClient = "Lluís Plans";
        dni="78659101A";
        camping.afegirClient(nomClient, dni);

    }


    /**
     * Mètode per fer reserves d'allotjaments.
     * @param camping
     */
    private static void ferReserves(Camping camping){

        String idAllotjament;
        String dni;

        LocalDate dataEntrada;
        LocalDate dataSortida;


        // 1a reserva
        idAllotjament = "100P";
        dni = "12345678X";

        dataEntrada = LocalDate.of(2026,2,20);
        dataSortida = LocalDate.of(2026,2,28);

        try {
            camping.afegirReserva(idAllotjament,dni,dataEntrada,dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }


        // 2a reserva
        idAllotjament = "100P";
        dni = "78659101A";

        dataEntrada = LocalDate.of(2026,2,25);
        dataSortida = LocalDate.of(2026,2,28);

        try {
            camping.afegirReserva(idAllotjament,dni,dataEntrada,dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }


        // 3a reserva
        idAllotjament = "300Z";
        dni = "789101A";

        dataEntrada = LocalDate.of(2026,2,25);
        dataSortida = LocalDate.of(2026,2,28);

        try {
            camping.afegirReserva(idAllotjament,dni,dataEntrada,dataSortida);
        } catch (ExcepcioReserva e) {
            System.out.println(e.getMessage());
        }

    }

}