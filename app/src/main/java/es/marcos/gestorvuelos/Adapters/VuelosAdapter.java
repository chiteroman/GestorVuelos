package es.marcos.gestorvuelos.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.LinkedList;

import es.marcos.gestorvuelos.Models.Vuelo;
import es.marcos.gestorvuelos.R;

public class VuelosAdapter extends ArrayAdapter<Vuelo> {
    private final Context context;
    private final LinkedList<Vuelo> vuelos;

    public VuelosAdapter(@NonNull Context context, @NonNull LinkedList<Vuelo> objects) {
        super(context, 0, objects);
        this.context = context;
        this.vuelos = objects;
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.platilla_vuelos, null);
        }

        ImageView imagen_avion = convertView.findViewById(R.id.imagen_avion);
        TextView nombre_avion = convertView.findViewById(R.id.nombre_avion);
        TextView destino = convertView.findViewById(R.id.destino);
        TextView horaSalida = convertView.findViewById(R.id.horaSalida);
        TextView horaLlegada = convertView.findViewById(R.id.horaLlegada);
        TextView pasajeros = convertView.findViewById(R.id.pasajeros);
        TextView aeropuerto_origen = convertView.findViewById(R.id.aeropuerto_origen);

        Vuelo vuelo = vuelos.get(position);

        Glide.with(context).load(vuelo.getAvion().getUrl()).into(imagen_avion);
        nombre_avion.setText(vuelo.getAvion().getModelo());
        destino.setText(vuelo.getAeropuertoDestino().getNombre());
        horaSalida.setText(vuelo.getHoraSalidaOrigen());
        horaLlegada.setText(vuelo.getHoraLlegadaDestino());
        pasajeros.setText(Integer.toString(vuelo.getUsuarios().size()));
        aeropuerto_origen.setText(vuelo.getAeropuertoSalida().getNombre());

        return convertView;
    }
}
