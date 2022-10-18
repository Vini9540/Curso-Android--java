package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas", "Campos do Jordao", "Costa do Sauipe", "Ilheus", "Porto Seguro", "Tiradentes",
            "Praga", "Santiago", "Zurique", "Caribe", "Buenos Aires", "Budapeste", "Cancun", "Aruba"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLocais = findViewById(R.id.listLocais);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, itens);

        listLocais.setAdapter(adaptador);


    }
}