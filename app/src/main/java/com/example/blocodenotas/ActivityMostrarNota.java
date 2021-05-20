package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.blocodenotas.controller.NotaController;

import org.w3c.dom.Text;

public class ActivityMostrarNota extends AppCompatActivity {

    TextView tvTitulo, tvTexto;
    NotaController notaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_nota);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvTexto = findViewById(R.id.tvTexto);
        notaController = new NotaController(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle bundle = getIntent().getExtras();
        Integer id_nota = bundle.getInt("id_nota") + 1;

        tvTitulo.setText(notaController.getNota(id_nota).getTitulo());
        tvTexto.setText(notaController.getNota(id_nota).getTexto());
    }
}