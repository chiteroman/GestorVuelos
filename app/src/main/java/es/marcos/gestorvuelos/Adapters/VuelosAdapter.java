package es.marcos.gestorvuelos.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

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

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.platilla_vuelos, null);
        }

    }
}
