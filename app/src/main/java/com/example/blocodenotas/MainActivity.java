package com.example.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.blocodenotas.controller.NotaController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listNotas;
    NotaController notaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNotas = findViewById(R.id.listNotas);
        notaController = new NotaController(getApplicationContext());
    }

    @Override
    protected void onStart() {
        super.onStart();
        NotaController notaController = new NotaController(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            notaController.listaTitulosNotas()
        );

        listNotas.setAdapter(adapter);

        listNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                showViewExibirNota(position);
//            }
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                removerNota(position);
            }
        });

        listNotas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                removerNota(position);

                return false;
            }
        });
    }


    public void criarNota(View v) {
        this.showViewCriarNota();
    }

    public void showViewCriarNota() {
        Intent intent = new Intent(this, ActivityExibirNota.class);
        startActivity(intent);
    }

    public void showViewExibirNota(Integer id_nota) {
        Intent intent = new Intent(this, ActivityMostrarNota.class);
        intent.putExtra("id_nota", id_nota);
        startActivity(intent);
    }

    public void removerNota(Integer id_nota) {
        notaController.removerNota(id_nota + 1);
    }
}