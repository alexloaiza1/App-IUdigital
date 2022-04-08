package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button registrarse = findViewById(R.id.btnRegistrar);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), registroUsuario.class);
                startActivityForResult(intent, 0);
            }
        });

        Button entrar = findViewById(R.id.btnEntrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "El modulo aún no esta disponible", Toast.LENGTH_LONG).show();
               // Intent intent = new Intent (v.getContext(), registroUsuario.class);
                //startActivityForResult(intent, 0);
            }
        });
    }
}