package com.example.blocodenotas.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {

    SQLiteDatabase banco;
    public NotaDAO(Context context) {
        banco = context.openOrCreateDatabase("dbNotas", context.MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto VARCHAR)");
    }

    public Nota inserirNota(Nota nota) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("titulo", nota.getTitulo());
        contentValues.put("texto", nota.getTexto());
       int i = (int)banco.insert("notas", null, contentValues);
       nota.setId(i);
       return nota;
    }

    public Nota getNota(Integer id_nota) {
        Cursor cursor = banco.rawQuery("SELECT * FROM notas WHERE id = " + Integer.toString(id_nota), null);
        cursor.moveToFirst();
        return new Nota(cursor.getString(1), cursor.getString(2));
    }

    public ArrayList<Nota> getListaNotas() {
        Cursor cursor = banco.rawQuery("SELECT * FROM NOTAS", null);
        cursor.moveToFirst();
        ArrayList<Nota> arrayList = new ArrayList<>();
        while (!cursor.isAfterLast()) {
            Nota n = new Nota(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            arrayList.add(n);
            cursor.moveToNext();
        }

        return arrayList;
    }

    public void removerNota(Integer id_nota) {
        banco.rawQuery("DELETE FROM notas WHERE id = " + Integer.toString(id_nota), null);
    }
}
