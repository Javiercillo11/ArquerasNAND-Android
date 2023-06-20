package com.example.arquerasnand;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Button j;
Button d;
        j=findViewById(R.id.Jugar);
        j.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick (View v){
                Intent intent  =new Intent(MainActivity.this,Juego.class);
                intent.putExtra("niveles","intermedio");
                startActivity(intent);

            }
        });

        d = findViewById(R.id.dificultad);
        d.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent=new Intent(MainActivity.this,Dificultad.class);
                startActivity(intent);

            }
        });
    }
    public void arrancarMusica(View view){
        startService(new Intent(MainActivity.this, ServicioMusica.class));
    }
    public void stopMusica(View view){
        stopService(new Intent(MainActivity.this, ServicioMusica.class));
    }
}