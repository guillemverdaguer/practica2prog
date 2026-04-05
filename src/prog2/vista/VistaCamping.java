package prog2.vista;

import prog2.model.Camping;
import java.util.Scanner;

public class VistaCamping {

    private Camping camping;
    private Scanner sc;

    public enum OpcionsMenu {
        LLISTAR_TOTS_ALLOTJAMENTS,
        LLISTAR_ALLOTJAMENTS_OPERATIUS,
        LLISTAR_ALLOTJAMENTS_NO_OPERATIUS,
        LLISTAR_ACCESSOS_OBERTS,
        LLISTAR_ACCESSOS_TANCATS,
        LLISTAR_TASQUES_MANTENIMENT,
        AFEGIR_TASCA_MANTENIMENT,
        COMPLETAR_TASCA_MANTENIMENT,
        CALCULAR_ACCESSOS_NO_ACCESSIBLES,
        CALCULAR_METRES_TERRA,
        GUARDAR_CAMPING,
        RECUPERAR_CAMPING,
        SORTIR
    }

    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
        this.camping.inicialitzaDadesCamping();
        this.sc = new Scanner(System.in);
    }

    public void gestioCamping() {
        Menu<OpcionsMenu> menu = new Menu<>("Camping Green", OpcionsMenu.values());
        menu.setDescripcions(new String[]{
                "Llistar tots els allotjaments",
                "Llistar allotjaments operatius",
                "Llistar allotjaments no operatius",
                "Llistar accessos oberts",
                "Llistar accessos tancats",
                "Llistar tasques de manteniment actives",
                "Afegir tasca de manteniment",
                "Completar tasca de manteniment",
                "Calcular accessos no accessibles amb vehicle",
                "Calcular metres totals accessos de terra",
                "Guardar camping",
                "Recuperar camping",
                "Sortir"
        });
        OpcionsMenu opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            switch (opcio) {
                case LLISTAR_TOTS_ALLOTJAMENTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("operatiu"));
                        System.out.println(camping.llistarAllotjaments("no operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ALLOTJAMENTS_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ALLOTJAMENTS_NO_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("no operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        System.out.println(camping.llistarAccessos("Obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_ACCESSOS_TANCATS:
                    try {
                        System.out.println(camping.llistarAccessos("Tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case LLISTAR_TASQUES_MANTENIMENT:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_TASCA_MANTENIMENT:
                    try {
                        System.out.print("Número de la tasca: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Id de l'allotjament: ");
                        String idAllotjament = sc.nextLine();
                        System.out.print("Tipus de tasca (Reparacio/Neteja/RevisioTecnica/Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies esperats: ");
                        int dies = sc.nextInt();
                        sc.nextLine();
                        camping.afegirTascaManteniment(num, tipus, idAllotjament, data, dies);
                        System.out.println("Tasca afegida");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case COMPLETAR_TASCA_MANTENIMENT:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Número de la tasca a completar: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        camping.completarTascaManteniment(num);
                        System.out.println("Tasca completada");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CALCULAR_ACCESSOS_NO_ACCESSIBLES:
                    try {
                        System.out.println("Número d'accessos sense accessibilitat amb vehicle: " + camping.calculaAccessosNoAccessibles());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case CALCULAR_METRES_TERRA:
                    try {
                        System.out.println("Total metres accessos de terra: " + camping.calculaMetresTerra());
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case GUARDAR_CAMPING:
                    try {
                        System.out.print("Ruta del fitxer: ");
                        String cami = sc.nextLine();
                        camping.save(cami);
                        System.out.println("Camping guardat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case RECUPERAR_CAMPING:
                    try {
                        System.out.print("Ruta del fitxer: ");
                        String cami = sc.nextLine();
                        camping = Camping.load(cami);
                        System.out.println("Camping recuperat correctament");
                    } catch (ExcepcioCamping e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case SORTIR:
                    System.out.println("Sortint...");
                    break;
            }
        } while (opcio != OpcionsMenu.SORTIR);
        sc.close();
    }
}