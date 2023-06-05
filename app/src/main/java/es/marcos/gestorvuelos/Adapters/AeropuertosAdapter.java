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

import es.marcos.gestorvuelos.Models.Aeropuerto;
import es.marcos.gestorvuelos.R;

public class AeropuertosAdapter extends ArrayAdapter<Aeropuerto> {
    private final Context context;
    private final LinkedList<Aeropuerto> aeropuertos;

    public AeropuertosAdapter(@NonNull Context context, @NonNull LinkedList<Aeropuerto> objects) {
        super(context, 0, objects);
        this.context = context;
        this.aeropuertos = objects;
    }


    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.platilla_aeropuerto, null);
        }

        Aeropuerto aeropuerto = aeropuertos.get(position);

        ImageView imageView = convertView.findViewById(R.id.imagen);
        TextView textView = convertView.findViewById(R.id.nombre);

        Glide.with(context).load(aeropuerto.getUrl()).into(imageView);
        textView.setText(aeropuerto.getNombre());

        return convertView;
    }
}
