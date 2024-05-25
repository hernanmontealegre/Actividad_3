package com.example.actividad1_2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerProducto extends RecyclerView.ViewHolder {
    TextView textViewNombreJugador, textViewPosicionJugador, textViewPrecioJugador;

    public VerProducto(@NonNull View itemView) {
        super(itemView);
        textViewNombreJugador = itemView.findViewById(R.id.textNombreJugador);
        textViewPosicionJugador = itemView.findViewById(R.id.textPosicionJugador);
        textViewPrecioJugador = itemView.findViewById(R.id.textPrecioJugador);
    }
}