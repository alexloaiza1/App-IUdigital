package com.example.app_iudigital.adapatadores;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_iudigital.R;
import com.example.app_iudigital.entidades.Estudiantes;

import java.util.ArrayList;

public class ListaEstudiantesAdapter extends RecyclerView.Adapter<ListaEstudiantesAdapter.EstudianteViewHolder> {

    ArrayList<Estudiantes> listaEstudiantes;
    ArrayList<Estudiantes> listaOriginal;


    public ListaEstudiantesAdapter(ArrayList<Estudiantes> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaEstudiantes);
    }

    @NonNull
    @Override
    public EstudianteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_lista_estudiantes_adapter, null, false);
        return new EstudianteViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EstudianteViewHolder holder, int position) {
        holder.viewNombre.setText(listaEstudiantes.get(position).getNombre());
        holder.viewDocumento.setText(listaEstudiantes.get(position).getDocumento());
        holder.viewPrograma.setText(listaEstudiantes.get(position).getPrograma());
        holder.viewEmail.setText(listaEstudiantes.get(position).getEmail());
    }

    public int getItemCount() {
        return listaEstudiantes.size();
    }


    public class EstudianteViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewDocumento, viewPrograma, viewEmail;

        public EstudianteViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewDocumento = itemView.findViewById(R.id.viewDocumento);
            viewPrograma = itemView.findViewById(R.id.viewPrograma);
            viewEmail = itemView.findViewById(R.id.viewEmail);



        }
    }

}