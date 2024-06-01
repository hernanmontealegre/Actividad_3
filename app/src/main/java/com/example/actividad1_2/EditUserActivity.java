package com.example.actividad1_2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditUserActivity extends AppCompatActivity {
    private EditText editTextName, editTextEmail, editTextFecNac, editTextTelefono, editTextPassword;
    private Button buttonSave;
    private DatabaseReference userRef;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);

        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFecNac = findViewById(R.id.editTextFecNac);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSave = findViewById(R.id.buttonSave);

        userId = getIntent().getStringExtra("userId");
        userRef = FirebaseDatabase.getInstance().getReference("usuarios").child(userId);

        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuario user = dataSnapshot.getValue(Usuario.class);
                if (user != null) {
                    editTextName.setText(user.getNombre());
                    editTextEmail.setText(user.getCorreo());
                    editTextFecNac.setText(user.getFec_nac());
                    editTextTelefono.setText(user.getTelefono());
                    editTextPassword.setText(user.getPassword());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Manejar el error
            }
        });

        buttonSave.setOnClickListener(v -> {
            String nombre = editTextName.getText().toString();
            String correo = editTextEmail.getText().toString();
            String fecNac = editTextFecNac.getText().toString();
            String telefono = editTextTelefono.getText().toString();
            String password = editTextPassword.getText().toString();

            userRef.child("nombre").setValue(nombre);
            userRef.child("correo").setValue(correo);
            userRef.child("fec_nac").setValue(fecNac);
            userRef.child("telefono").setValue(telefono);
            userRef.child("password").setValue(password);

            finish();
        });
    }
}
