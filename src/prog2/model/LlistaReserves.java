package prog2.model;

import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> reserves;

    public LlistaReserves() {
        reserves = new ArrayList<>();
    }

    public boolean allotjamentDisponible(Allotjament allotjament,
                                         LocalDate dataEntrada,
                                         LocalDate dataSortida) {

        for (Reserva r : reserves) {

            if (r.getAllotjament().getId().equals(allotjament.getId())) {

                if (!(dataSortida.isBefore(r.getDataEntrada()) ||
                        dataEntrada.isAfter(r.getDataSortida()))) {

                    return false;
                }
            }
        }

        return true;
    }

    // comprobar estancia mínima
    public boolean isEstadaMinima(Allotjament allotjament,
                                  LocalDate dataEntrada,
                                  LocalDate dataSortida) {

        long dies = ChronoUnit.DAYS.between(dataEntrada, dataSortida);

        InAllotjament.Temp temp = Allotjament.getTemporada(dataEntrada);

        return dies >= allotjament.getEstadaMinima(temp);
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client,
                              LocalDate dataEntrada, LocalDate dataSortida)
            throws ExcepcioReserva {

        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {

            throw new ExcepcioReserva(
                    "L’allotjament amb identificador " + allotjament.getId() +
                            " no està disponible en la data demanada " + dataEntrada +
                            " pel client " + client.getNom() +
                            " amb DNI: " + client.getDni() + "."
            );
        }

        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {

            throw new ExcepcioReserva(
                    "Les dates sol·licitades pel client " + client.getNom() +
                            " amb DNI: " + client.getDni() +
                            " no compleixen l'estada mínima per l'allotjament amb identificador " +
                            allotjament.getId() + "."
            );
        }

        Reserva reserva = new Reserva(allotjament, client, dataEntrada, dataSortida);

        reserves.add(reserva);
    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }

    public ArrayList<Reserva> getReserves() {
        return reserves;
    }
}