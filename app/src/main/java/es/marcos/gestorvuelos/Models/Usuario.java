package es.marcos.gestorvuelos.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Usuario {
    @SerializedName("id")
    long id;
    @SerializedName("androidId")
    String androidId;
    @SerializedName("vuelos")
    List<Vuelo> vuelos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
