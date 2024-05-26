package com.example.actividad1_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistroActivity extends AppCompatActivity {
    EditText nombreText, correoText, fec_nacText, telefonoText, passwordText;

    Button btnRegistro;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgistro);

        nombreText = findViewById(R.id.nombre);
        correoText = findViewById(R.id.correo);
        fec_nacText = findViewById(R.id.fec_nac);
        telefonoText = findViewById(R.id.telefono);
        passwordText = findViewById(R.id.password);
        btnRegistro = findViewById(R.id.btnRegistro);

        mDatabase = FirebaseDatabase.getInstance().getReference();//inicializa la referencia a firebase db
        btnRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Usuario usuario=new Usuario();
                usuario.setId(UUID.randomUUID().toString());
                usuario.setNombre(nombreText.getText().toString());
                usuario.setCorreo(correoText.getText().toString());
                usuario.setFec_nac(fec_nacText.getText().toString());
                usuario.setTelefono(telefonoText.getText().toString());
                usuario.setPassword(passwordText.getText().toString());
                mDatabase.child("usuarios").child(usuario.getId()).setValue(usuario);
                Toast.makeText(RegistroActivity.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();

                // Después del registro, se dirige nuevamente al MainActivity
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar RegistroActivity para evitar que el usuario regrese aquí al presionar el botón Atrás
            }
        });

    }
}
