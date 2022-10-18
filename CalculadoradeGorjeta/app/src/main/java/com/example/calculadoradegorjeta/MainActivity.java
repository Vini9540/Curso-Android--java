package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem;
    private TextView textValorGorjeta;
    private TextView textValorTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textValorGorjeta = findViewById(R.id.textValorGorjeta);
        textValorTotal = findViewById(R.id.textValorTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular() {

        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {
            Toast.makeText(
                    getApplicationContext(), "Digite um valor primeiro",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            double valorDigitado = Double.parseDouble(valorRecuperado);

            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            textValorGorjeta.setText("R$ " + Math.round(gorjeta));
            textValorTotal.setText("R$ " + total);
        }
    }
}