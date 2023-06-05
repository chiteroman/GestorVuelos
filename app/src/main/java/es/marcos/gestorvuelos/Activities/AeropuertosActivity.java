package es.marcos.gestorvuelos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import es.marcos.gestorvuelos.API.Client;
import es.marcos.gestorvuelos.Adapters.AeropuertosAdapter;
import es.marcos.gestorvuelos.Models.Aeropuerto;
import es.marcos.gestorvuelos.R;
import retrofit2.Response;

public class AeropuertosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aeropuertos);

        try {
            Response<List<Aeropuerto>> response = Client.getApi().getAeropuertos().execute();
            LinkedList<Aeropuerto> aeropuertos = response.body() != null ? new LinkedList<>(response.body()) : null;

            if (aeropuertos == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("No se ha encontrado ningún aeropuerto. ¿Estás conectado a Internet?");
                builder.setPositiveButton("Aceptar", (dialog, which) -> AeropuertosActivity.this.finish());
                builder.create().show();
                return;
            } else if (aeropuertos.isEmpty()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ADVERTENCIA");
                builder.setMessage("No hay aeropuertos en el servidor");
                builder.setPositiveButton("Aceptar", (dialog, which) -> AeropuertosActivity.this.finish());
                builder.create().show();
                return;
            }

            ListView lista = findViewById(R.id.lista);

            AeropuertosAdapter adapter = new AeropuertosAdapter(this, aeropuertos);
            lista.setAdapter(adapter);

            lista.setOnItemClickListener((parent, view, position, id) -> {
                Aeropuerto aeropuerto = aeropuertos.get(position);
                Intent intent = new Intent(this, VuelosActivity.class);
                intent.putExtra("aeropuerto", aeropuerto);
                startActivity(intent);
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}