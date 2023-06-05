package es.marcos.gestorvuelos.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Aeropuerto implements Serializable {
    @SerializedName("id")
    private long id;
    @SerializedName("nombre")
    private String nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
