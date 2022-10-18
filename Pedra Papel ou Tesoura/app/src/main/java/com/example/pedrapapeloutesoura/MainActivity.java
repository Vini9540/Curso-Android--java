package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imageresultado = findViewById(R.id.imageResultado);
        TextView textoresultado =findViewById(R.id.textResultado);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];
        switch (escolhaApp) {
            case "Pedra":
                imageresultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageresultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageresultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if(
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ){
            textoresultado.setText("Você Perdeu :( !!!");
        }else if(
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")){
            textoresultado.setText("Você Ganhou :) !!!");
        }else{
            textoresultado.setText("Empatamos!!!");
        }


    }

}