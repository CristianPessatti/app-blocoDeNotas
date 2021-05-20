package com.example.blocodenotas.controller;

import android.content.Context;

import com.example.blocodenotas.modelo.Nota;
import com.example.blocodenotas.modelo.NotaDAO;

import java.util.ArrayList;

public class NotaController {
    private Context mContext;
    NotaDAO notaDAO;
    public NotaController(Context context) {
        notaDAO = new NotaDAO(context);
    }

    public Nota cadastrarNovaNota(Nota nota) {
        return notaDAO.inserirNota(nota);
    }

    public Nota getNota(Integer id_nota) {
        return notaDAO.getNota(id_nota);
    }

    public ArrayList<Nota> listaNotas() {
        return notaDAO.getListaNotas();
    }

    public ArrayList<String> listaTitulosNotas() {
        ArrayList<String> result = new ArrayList<>();

        for (Nota nota: this.listaNotas()) {
            result.add(nota.getTitulo());
        }

        return result;
    }

    public void removerNota(Integer id_nota) {
        notaDAO.removerNota(id_nota);
    }
}
