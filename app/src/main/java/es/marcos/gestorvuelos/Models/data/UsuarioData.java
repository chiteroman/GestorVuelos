package es.marcos.gestorvuelos.Models.data;

public class UsuarioData {
    long vuelo_id;
    String androidId;

    public UsuarioData() {
    }

    public UsuarioData(long vuelo_id, String androidId) {
        this.vuelo_id = vuelo_id;
        this.androidId = androidId;
    }

    public long getVuelo_id() {
        return vuelo_id;
    }

    public void setVuelo_id(long vuelo_id) {
        this.vuelo_id = vuelo_id;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }
}
