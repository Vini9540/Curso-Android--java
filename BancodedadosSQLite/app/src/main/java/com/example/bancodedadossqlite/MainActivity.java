package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR , idade INT (3) )");

            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Vinicius', 20)");
            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mario', 50)");

            Cursor cursor = bancoDados.rawQuery("SELECT nome, idade FROM pessoas ", null);

            while (cursor != null ){
                Log.i("RESULTADO - nome", cursor.getString(0));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}