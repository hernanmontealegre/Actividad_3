package com.example.actividad1_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.VerProducto> {
    private Context context;
    private List<Jugador> jugadores;

    public Adaptador(Context context, List<Jugador> jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @NonNull
    @Override
    public VerProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false);
        return new VerProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerProducto holder, int position) {
        Jugador jugador = jugadores.get(position);
        holder.textViewNombreJugador.setText(jugador.getNombre());
        holder.textViewPosicionJugador.setText(jugador.getPosicion());
        holder.textViewPrecioJugador.setText(jugador.getPrecio());
        holder.checkBoxProducto1.setChecked(jugador.isSeleccionado());

        holder.checkBoxProducto1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            jugador.setSeleccionado(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return jugadores.size();
    }

    public class VerProducto extends RecyclerView.ViewHolder {
        TextView textViewNombreJugador, textViewPosicionJugador, textViewPrecioJugador;
        CheckBox checkBoxProducto1;

        public VerProducto(@NonNull View itemView) {
            super(itemView);
            textViewNombreJugador = itemView.findViewById(R.id.textNombreJugador);
            textViewPosicionJugador = itemView.findViewById(R.id.textPosicionJugador);
            textViewPrecioJugador = itemView.findViewById(R.id.textPrecioJugador);
            checkBoxProducto1 = itemView.findViewById(R.id.checkBoxProducto1);
        }
    }
}
