package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class registroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        Button volver = findViewById(R.id.btnvolverInicio);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), LoginActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Button registrarse = findViewById(R.id.btnregistrarUser);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(registroUsuario.this, "La funcionalidad aún esta en desarrollo", Toast.LENGTH_LONG).show();
                // Intent intent = new Intent (v.getContext(), registroUsuario.class);
                //startActivityForResult(intent, 0);
            }
        });
    }
}