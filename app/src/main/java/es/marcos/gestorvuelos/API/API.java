package es.marcos.gestorvuelos.API;

import java.util.List;

import es.marcos.gestorvuelos.Models.Aeropuerto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("aeropuertos")
    Call<List<Aeropuerto>> getAeropuertos();
}
