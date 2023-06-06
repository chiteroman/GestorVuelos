package es.marcos.gestorvuelos.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Aeropuerto {
    @SerializedName("id")
    private long id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("url")
    private String url;
    @SerializedName("vuelosSalidas")
    private List<Vuelo> vuelosSalidas;
    @SerializedName("vuelosLlegadas")
    private List<Vuelo> vuelosLlegadas;

    public Aeropuerto(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

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

    public List<Vuelo> getVuelosSalidas() {
        return vuelosSalidas;
    }

    public void setVuelosSalidas(List<Vuelo> vuelosSalidas) {
        this.vuelosSalidas = vuelosSalidas;
    }

    public List<Vuelo> getVuelosLlegadas() {
        return vuelosLlegadas;
    }

    public void setVuelosLlegadas(List<Vuelo> vuelosLlegadas) {
        this.vuelosLlegadas = vuelosLlegadas;
    }
}
