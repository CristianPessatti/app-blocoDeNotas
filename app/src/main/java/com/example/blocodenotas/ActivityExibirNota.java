package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.blocodenotas.controller.NotaController;
import com.example.blocodenotas.modelo.Nota;

public class ActivityExibirNota extends AppCompatActivity {

    NotaController notaController;
    EditText edTitulo, edTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_nota);
        notaController = new NotaController(getApplicationContext());

        edTitulo = findViewById(R.id.edTitulo);
        edTexto = findViewById(R.id.edTexto);
    }

    public void salvarNota(View v) {
        notaController.cadastrarNovaNota(new Nota(edTitulo.getText().toString(), edTexto.getText().toString()));
    }
}