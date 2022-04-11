package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button registrarEstudiante = findViewById(R.id.btnRegistrarEstudiante);
        registrarEstudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, registroUsuario.class);
                startActivity(intent);
                Toast.makeText(Menu.this, "Ingresando a registro de estudiante", Toast.LENGTH_LONG).show();
            }
        });
    }
}