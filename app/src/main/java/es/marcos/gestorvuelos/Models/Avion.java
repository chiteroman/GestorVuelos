package es.marcos.gestorvuelos.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Avion {
    @SerializedName("id")
    private long id;
    @SerializedName("modelo")
    private String modelo;
    @SerializedName("url")
    private String url;
    @SerializedName("vuelos")
    private List<Vuelo> vuelos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
