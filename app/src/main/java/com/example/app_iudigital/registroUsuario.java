package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_iudigital.db.DbEstudiantes;

public class registroUsuario extends AppCompatActivity {

    EditText txtNombre,txtDocumento, txtPrograma, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        txtNombre=findViewById(R.id.txtNombre);
        txtDocumento=findViewById(R.id.txtDocumento);
        txtPrograma=findViewById(R.id.txtPrograma);
        txtEmail=findViewById(R.id.txtEmail);

        Button registrarse = findViewById(R.id.btnregistrarUser);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtNombre.getText().toString().equals("") && !txtDocumento.getText().toString().equals("")) {

                    DbEstudiantes DB = new DbEstudiantes(   registroUsuario.this);
                    long id = DB.insertarEstudiante(txtNombre.getText().toString(), txtDocumento.getText().toString(), txtPrograma.getText().toString(), txtEmail.getText().toString());

                    if (id > 0) {
                        Toast.makeText(registroUsuario.this, "ESTUDIANTE GUARDADO", Toast.LENGTH_LONG).show();
                        limpiar();
                    } else {
                        Toast.makeText(registroUsuario.this, "ERROR AL GUARDAR ESTUDIANTE", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(registroUsuario.this, "DEBE LLENAR TODOS LOS CAMPOS", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button volver = findViewById(R.id.btnvolverInicio);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Menu.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    private void limpiar() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtPrograma.setText("");
        txtEmail.setText("");

    }
}


