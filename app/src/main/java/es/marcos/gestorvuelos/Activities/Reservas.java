package es.marcos.gestorvuelos.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import es.marcos.gestorvuelos.API.Client;
import es.marcos.gestorvuelos.Adapters.VuelosAdapter;
import es.marcos.gestorvuelos.Models.Vuelo;
import es.marcos.gestorvuelos.Models.data.AndroidIdData;
import es.marcos.gestorvuelos.Models.data.UsuarioData;
import es.marcos.gestorvuelos.R;
import retrofit2.Response;

@SuppressLint("HardwareIds")
public class Reservas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);

        if (androidId == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("No se han podido obtener tus reservas");
            builder.setPositiveButton("Aceptar", (dialog, which) -> Reservas.this.finish());
            builder.create().show();
            return;
        }

        try {
            AndroidIdData androidIdData = new AndroidIdData(androidId);
            Response<List<Vuelo>> response = Client.api.getVuelosByUsuarioAndroidId(androidIdData).execute();
            LinkedList<Vuelo> vuelos = response.body() == null ? null : new LinkedList<>(response.body());

            if (vuelos == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("No se puede conseguir tus reservas");
                builder.setPositiveButton("Aceptar", (dialog, which) -> Reservas.this.finish());
                builder.create().show();
                return;
            } else if (vuelos.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ADVERTENCIA");
                builder.setMessage("No tienes reservas");
                builder.setPositiveButton("Aceptar", (dialog, which) -> Reservas.this.finish());
                builder.create().show();
                return;
            }

            ListView lista = findViewById(R.id.lista_reservas);

            VuelosAdapter adapter = new VuelosAdapter(this, vuelos);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener((parent, view, position, id) -> {
                Vuelo vuelo = vuelos.get(position);
                UsuarioData data = new UsuarioData(vuelo.getId(), androidId);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("RESERVA");
                builder.setMessage("¿Deseas cancelar la reserva?");
                builder.setPositiveButton("Sí", (dialog, which) -> cancelarReserva(data));
                builder.setNegativeButton("No", null);
                builder.create().show();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cancelarReserva(UsuarioData usuarioData) {
        try {
            Response<Boolean> response = Client.api.cancelarReserva(usuarioData).execute();
            boolean resultado = response.body() != null && response.body();

            if (!resultado) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("No se ha podido cancelar tu reserva");
                builder.setPositiveButton("Aceptar", (dialog, which) -> Reservas.this.finish());
                builder.create().show();
                return;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("RESERVAS");
            builder.setMessage("Reserva cancelada");
            builder.setPositiveButton("Aceptar", (dialog, which) -> Reservas.this.finish());
            builder.create().show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}