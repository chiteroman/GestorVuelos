package es.marcos.gestorvuelos.API;

import java.util.List;

import es.marcos.gestorvuelos.Models.Aeropuerto;
import es.marcos.gestorvuelos.Models.Vuelo;
import es.marcos.gestorvuelos.Models.data.AndroidIdData;
import es.marcos.gestorvuelos.Models.data.UsuarioData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface API {
    @GET("aeropuertos")
    Call<List<Aeropuerto>> getAeropuertos();

    @GET("vuelos/{id_aeropuerto}")
    Call<List<Vuelo>> getVuelosByAeropuertoId(@Path("id_aeropuerto") long id_aeropuerto);

    @POST("vuelos/reservar")
    Call<Boolean> reservarVuelo(@Body UsuarioData usuarioData);

    @POST("usuarios/vuelos")
    Call<List<Vuelo>> getVuelosByUsuarioAndroidId(@Body AndroidIdData androidIdData);

    @POST("vuelos/reservar/cancelar")
    Call<Boolean> cancelarReserva(@Body UsuarioData data);
}
