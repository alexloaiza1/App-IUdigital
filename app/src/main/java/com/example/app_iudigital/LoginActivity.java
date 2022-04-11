package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usuario, contraseña;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=findViewById(R.id.txtUsuario);
        contraseña=findViewById(R.id.txtContraseña);

        String user = "DOCENTE";
        String pass = "12345";

        Button entrar = findViewById(R.id.btnEntrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String docente=usuario.getText().toString();
                String password=contraseña.getText().toString();
                if (docente.equals(user)&& password.equals(pass)) {
                    Intent intent  = new Intent(LoginActivity.this,Menu.class) ;
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Usuario y/o Contraseña incorrectos", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}