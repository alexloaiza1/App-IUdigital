package com.example.app_iudigital.db;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.app_iudigital.entidades.Estudiantes;

import java.util.ArrayList;

public class DbEstudiantes extends DbHelper {

    Context context;

    public DbEstudiantes(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarEstudiante(String nombre, String documento, String programa, String email) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("documento", documento);
            values.put("programa", programa);
            values.put("email", email);


            id = db.insert(TABLE_ESTUDIANTES, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<Estudiantes> mostrarEstudiantes() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Estudiantes> listaEstudiantes = new ArrayList<>();
        Estudiantes estudiante;
        Cursor cursorEstudiantes;

        cursorEstudiantes = db.rawQuery("SELECT * FROM " + TABLE_ESTUDIANTES + " ORDER BY nombre ASC", null);

        if (cursorEstudiantes.moveToFirst()) {
            do {
                estudiante = new Estudiantes();
                estudiante.setId(cursorEstudiantes.getInt(0));
                estudiante.setNombre(cursorEstudiantes.getString(1));
                estudiante.setDocumento(cursorEstudiantes.getString(2));
                estudiante.setPrograma(cursorEstudiantes.getString(3));
                estudiante.setEmail(cursorEstudiantes.getString(4));

                listaEstudiantes.add(estudiante);
            } while (cursorEstudiantes.moveToNext());
        }

        cursorEstudiantes.close();

        return listaEstudiantes;
    }

    public Estudiantes verEstudiante(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Estudiantes estudiante = null;
        Cursor cursorEstudiantes;

        cursorEstudiantes = db.rawQuery("SELECT * FROM " + TABLE_ESTUDIANTES + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorEstudiantes.moveToFirst()) {
            estudiante = new Estudiantes();
            estudiante.setId(cursorEstudiantes.getInt(0));
            estudiante.setNombre(cursorEstudiantes.getString(1));
            estudiante.setDocumento(cursorEstudiantes.getString(2));
            estudiante.setPrograma(cursorEstudiantes.getString(3));
            estudiante.setEmail(cursorEstudiantes.getString(4));

        }

        cursorEstudiantes.close();

        return estudiante;
    }



    public boolean eliminarEstudiante(int id) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_ESTUDIANTES + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }
}

