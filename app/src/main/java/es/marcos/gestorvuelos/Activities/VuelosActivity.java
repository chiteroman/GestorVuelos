package es.marcos.gestorvuelos.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.Settings;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import es.marcos.gestorvuelos.API.Client;
import es.marcos.gestorvuelos.Adapters.VuelosAdapter;
import es.marcos.gestorvuelos.Models.Vuelo;
import es.marcos.gestorvuelos.Models.data.UsuarioData;
import es.marcos.gestorvuelos.R;
import retrofit2.Response;

public class VuelosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuelos);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView textView = findViewById(R.id.nombre_aeropuerto);

        long id_aeropuerto = getIntent().getLongExtra("id_aeropuerto", -1);
        String nombre_aeropuerto = getIntent().getStringExtra("nombre_aeropuerto");

        if (id_aeropuerto == -1 || nombre_aeropuerto == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("Aeropuerto no válido");
            builder.setPositiveButton("Aceptar", (dialog, which) -> VuelosActivity.this.finish());
            builder.create().show();
            return;
        }

        try {
            Response<List<Vuelo>> response = Client.api.getVuelosByAeropuertoId(id_aeropuerto).execute();
            LinkedList<Vuelo> vuelos = response.body() == null ? null : new LinkedList<>(response.body());

            textView.setText(nombre_aeropuerto);

            if (vuelos == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("No se han podido obtener los vuelos");
                builder.setPositiveButton("Aceptar", (dialog, which) -> VuelosActivity.this.finish());
                builder.create().show();
                return;
            } else if (vuelos.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ADVERTENCIA");
                builder.setMessage("Este aeropuerto no tiene vuelos programados");
                builder.setPositiveButton("Aceptar", (dialog, which) -> VuelosActivity.this.finish());
                builder.create().show();
                return;
            }

            ListView lista = findViewById(R.id.listaVuelos);

            VuelosAdapter adapter = new VuelosAdapter(this, vuelos);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener((parent, view, position, id) -> {
                Vuelo vuelo = vuelos.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("RESERVAR");
                builder.setMessage("¿Deseas comprar un asiento para este vuelo?");
                builder.setPositiveButton("Aceptar", (dialog, which) -> reservarVuelo(vuelo));
                builder.setNegativeButton("Cancelar", null);
                builder.create().show();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("HardwareIds")
    private void reservarVuelo(Vuelo vuelo) {
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        UsuarioData usuarioData = new UsuarioData(vuelo.getId(), androidId);
        try {
            Response<Boolean> response = Client.api.reservarVuelo(usuarioData).execute();
            boolean result = Boolean.TRUE.equals(response.body());

            if (!result) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("Error al reservar el vuelo");
                builder.setPositiveButton("Aceptar", null);
                builder.create().show();
                return;
            }

            Toast.makeText(this, "Se ha reservado su vuelo", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}