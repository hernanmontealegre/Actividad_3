package com.example.actividad1_2;

        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class activity_carrito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        ArrayList<Jugador> jugadoresSeleccionados = (ArrayList<Jugador>) getIntent().getSerializableExtra("jugadoresSeleccionados");

        RecyclerView recyclerViewCarrito = findViewById(R.id.recyclerViewCarrito);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        Adaptador adapter = new Adaptador(this, jugadoresSeleccionados);
        recyclerViewCarrito.setAdapter(adapter);
    }
}
