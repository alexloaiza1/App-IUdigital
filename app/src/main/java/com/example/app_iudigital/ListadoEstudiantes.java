package com.example.app_iudigital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_iudigital.adapatadores.ListaEstudiantesAdapter;
import com.example.app_iudigital.db.DbEstudiantes;
import com.example.app_iudigital.entidades.Estudiantes;

import java.util.ArrayList;

public class ListadoEstudiantes extends AppCompatActivity {


    RecyclerView listaEstudiantes;
    ArrayList<Estudiantes> listaArrayEstudiantes;
    ListaEstudiantesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_estudiantes);
        listaEstudiantes = findViewById(R.id.listaEstudiantes);
        listaEstudiantes.setLayoutManager(new LinearLayoutManager(this));

        DbEstudiantes DB= new DbEstudiantes(ListadoEstudiantes.this);
        listaArrayEstudiantes = new ArrayList<>();
        adapter=new ListaEstudiantesAdapter(DB.mostrarEstudiantes());
        listaEstudiantes.setAdapter(adapter);


    }
}