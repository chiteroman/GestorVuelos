package es.marcos.gestorvuelos.Activities;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

import es.marcos.gestorvuelos.Adapters.VuelosAdapter;
import es.marcos.gestorvuelos.Models.Aeropuerto;
import es.marcos.gestorvuelos.Models.Vuelo;
import es.marcos.gestorvuelos.R;

public class VuelosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vuelos);

        Aeropuerto aeropuerto;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            aeropuerto = getIntent().getExtras().getSerializable("aeropuerto", Aeropuerto.class);
        } else {
            aeropuerto = (Aeropuerto) getIntent().getExtras().getSerializable("aeropuerto");
        }

        ListView lista = findViewById(R.id.listaVuelos);

        LinkedList<Vuelo> vuelos = new LinkedList<>(aeropuerto.getVuelos());
        VuelosAdapter adapter = new VuelosAdapter(this, vuelos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener((parent, view, position, id) -> {

        });
    }
}