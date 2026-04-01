package prog2.model;

import java.time.LocalDate;
import prog2.vista.ExcepcioReserva;


public class Reserva {

    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    public Reserva(Allotjament allotjament, Client client,
                   LocalDate dataEntrada, LocalDate dataSortida)throws ExcepcioReserva {

        if (dataSortida.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }

        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    public Allotjament getAllotjament() {
        return allotjament;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSortida() {
        return dataSortida;
    }

    public void setAllotjament(Allotjament allotjament) {
        this.allotjament = allotjament;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida = dataSortida;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "allotjament=" + allotjament.getId() +
                ", client=" + client.getNom() +
                ", entrada=" + dataEntrada +
                ", sortida=" + dataSortida +
                '}';
    }
}