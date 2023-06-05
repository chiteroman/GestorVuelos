package es.marcos.gestorvuelos.Models;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class Vuelo implements Serializable {
    private long id;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private ZonedDateTime horaSalidaOrigen;
    private ZonedDateTime horaLlegadaDestino;
    private int pasajeros;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public ZonedDateTime getHoraSalidaOrigen() {
        return horaSalidaOrigen;
    }

    public void setHoraSalidaOrigen(ZonedDateTime horaSalidaOrigen) {
        this.horaSalidaOrigen = horaSalidaOrigen;
    }

    public ZonedDateTime getHoraLlegadaDestino() {
        return horaLlegadaDestino;
    }

    public void setHoraLlegadaDestino(ZonedDateTime horaLlegadaDestino) {
        this.horaLlegadaDestino = horaLlegadaDestino;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
}
