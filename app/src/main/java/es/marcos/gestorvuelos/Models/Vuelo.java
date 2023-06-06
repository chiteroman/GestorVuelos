package es.marcos.gestorvuelos.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vuelo {
    @SerializedName("id")
    private long id;
    @SerializedName("avion")
    private Avion avion;
    @SerializedName("aeropuertoSalida")
    private Aeropuerto aeropuertoSalida;
    @SerializedName("aeropuertoDestino")
    private Aeropuerto aeropuertoDestino;
    @SerializedName("horaSalidaOrigen")
    private String horaSalidaOrigen;
    @SerializedName("horaLlegadaDestino")
    private String horaLlegadaDestino;
    @SerializedName("usuarios")
    private List<Usuario> usuarios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public String getHoraSalidaOrigen() {
        return horaSalidaOrigen;
    }

    public void setHoraSalidaOrigen(String horaSalidaOrigen) {
        this.horaSalidaOrigen = horaSalidaOrigen;
    }

    public String getHoraLlegadaDestino() {
        return horaLlegadaDestino;
    }

    public void setHoraLlegadaDestino(String horaLlegadaDestino) {
        this.horaLlegadaDestino = horaLlegadaDestino;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
