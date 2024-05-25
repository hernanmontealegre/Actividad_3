package com.example.actividad1_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Jugador> jugadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear una lista de jugadores
        jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Kylian Mbappé", "Delantero", "272 Millones de Euros"));
        jugadores.add(new Jugador("Jude Victor William Bellingham", "Centrocampista", "267 Millones de Euros"));
        jugadores.add(new Jugador("Erling Braut Haaland", "Delantero", "180 Millones de Euros"));
        jugadores.add(new Jugador("Vinicius José Paixão de Oliveira Júnior", "Delantero", "150 Millones de Euros"));
        jugadores.add(new Jugador("Pedro González López", "Centrocampista", "27 Millones de Euros"));
        jugadores.add(new Jugador("Pablo Martín Páez Gavira", "Centrocampista", "90 Millones de Euros"));
        jugadores.add(new Jugador("Philip Walter Foden", "Centrocampista", "190 Millones de Euros"));
        jugadores.add(new Jugador("Josko Gvardiol", "Defensa", "100 Millones de Euros"));
        jugadores.add(new Jugador("Virgil van Dijk", "Defensa", "84 Millones de Euros"));
        jugadores.add(new Jugador("Alisson Ramses Becker", "Arquero", "72 Millones de Euros"));
        jugadores.add(new Jugador("Ederson Santana de Moraes", "Arquero", "56 Millones de Euros"));

        // Configurar RecyclerView
        RecyclerView recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adapter = new Adaptador(this, jugadores);
        recyclerViewProducts.setAdapter(adapter);

        // Botón de registro
        Button btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
            startActivity(intent);
        });

        // Botón para iniciar sesión
        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Botón para ver carrito
        ImageView buttonVerCarrito = findViewById(R.id.imageViewCart);
        buttonVerCarrito.setOnClickListener(v -> {
            ArrayList<Jugador> jugadoresSeleccionados = new ArrayList<>();
            for (Jugador jugador : jugadores) {
                if (jugador.isSeleccionado()) {
                    jugadoresSeleccionados.add(jugador);
                }
            }
            Intent intent = new Intent(MainActivity.this, activity_carrito.class);
            intent.putExtra("jugadoresSeleccionados", jugadoresSeleccionados);
            startActivity(intent);
        });

        // Botón para ver mapa
        Button buttonMap = findViewById(R.id.buttonMap);
        buttonMap.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        });
    }
}
