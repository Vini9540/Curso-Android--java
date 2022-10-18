package com.example.meuprimeiroprojetp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ByteArrayInputStream btnSair;

    }

    public void alterarTexto(View view){
        TextView texto = findViewById(R.id.textoExibicao);
        texto.setText("Vinicius Souza");
    }
}