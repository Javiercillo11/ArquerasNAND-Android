package com.example.arquerasnand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dificultad extends AppCompatActivity {

    Button dificil;
    Button intermedio;
    Button facil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dificultad);

        dificil = findViewById(R.id.button3);
        dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dificultad.this,Juego.class);
                intent.putExtra("niveles","dificil");
                startActivity(intent);
            }
        });



        intermedio = findViewById(R.id.button2);
        intermedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dificultad.this,Juego.class);
                intent.putExtra("niveles","intermedio");
                startActivity(intent);
            }
        });


        facil = findViewById(R.id.button);
        facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dificultad.this,Juego.class);
                intent.putExtra("niveles","facil");
                startActivity(intent);
            }
        });


    }
}
