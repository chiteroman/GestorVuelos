package es.marcos.gestorvuelos.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import es.marcos.gestorvuelos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button iniciar = findViewById(R.id.iniciar);
        Button salir = findViewById(R.id.salir);

        iniciar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AeropuertosActivity.class);
            startActivity(intent);
        });

        salir.setOnClickListener(v -> System.exit(0));
    }
}