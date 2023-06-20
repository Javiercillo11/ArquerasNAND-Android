package com.example.arquerasnand;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Juego extends AppCompatActivity {

    Button bAzul;
    Button bBlanco;
    Button bAmarillo;
    Button bVerde;
    Button bMorado;
    Button bRojo;
    Button bNaranja;
    Button ponerOrcos;
    Button Bengala;
    Button BAtacar;
    Button BPasar;
    Button BMover;
    Button Ronda;
    Button Menu;

    TextView tvAzul;
    TextView tvRojo;
    TextView tvBlanco;
    TextView tvAmarillo;
    TextView tvVerde;
    TextView tvMorado;
    TextView tvNaranja;
    TextView tvFelchas;
    TextView tvCartas;
    TextView tvHordas;
    TextView tvCaballeros;

    int contCaballero;
    int contOrcos;
    int contBengala;
    int contMover;
    int contMover2;
    int batalla;
    int flechas;
    int cartas=32;
    int hordas;
    int bFinal;
    int contRondas=0;
    int Caballeros = 10;
    int ronda=0;

    Territorio Azul = new Territorio("Klifstenvik", 1, 0, 0, "VIVO");
    Territorio Rojo = new Territorio("Beknesvk", 2, 0, 0, "VIVO");
    Territorio Naranja = new Territorio("Klifdalholm", 3, 0, 0, "VIVO");
    Territorio Blanco = new Territorio("Bekstenholm", 4, 0, 0, "VIVO");
    Territorio Amarillo = new Territorio("Aestensand", 5, 0, 0, "VIVO");
    Territorio Verde = new Territorio("Aenesholm", 6, 0, 0, "VIVO");
    Territorio Morado = new Territorio("Bekdalsand", 7, 0, 0, "VIVO");

    ArrayList<Integer>hordasOrcos= new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

        String dificultad = getIntent().getStringExtra("niveles");
        Log.i("tag", dificultad);

        tvAzul = findViewById(R.id.tv1Azul);
        tvNaranja = findViewById(R.id.tv1Naranja);
        tvMorado = findViewById(R.id.tv1Morado);
        tvRojo = findViewById(R.id.tv1Rojo);
        tvVerde = findViewById(R.id.tv1Verde);
        tvBlanco = findViewById(R.id.tv1Blanco);
        tvAmarillo = findViewById(R.id.tv1Amarillo);

        //
        Bengala = (Button) findViewById(R.id.Bengala);
        Bengala.setEnabled(false);
        BAtacar = (Button) findViewById(R.id.BengAtacar);
        BAtacar.setEnabled(false);
        BPasar = (Button) findViewById(R.id.BengPasar);
        BPasar.setEnabled(false);
        BMover = (Button) findViewById(R.id.BengMover);
        BMover.setEnabled(false);
        Menu = (Button) findViewById(R.id.volver);
        Menu.setEnabled(false);

        switch (dificultad) {

            case "facil":
                flechas = 50;
                hordas = 10;
                tvFelchas = findViewById(R.id.ttv1);
                tvFelchas.setText("FLECHAS " + flechas);
                tvHordas = findViewById(R.id.ttv2);
                tvHordas.setText("HORDAS " + hordas);
                tvCartas = findViewById(R.id.tvCard);
                tvCartas.setText("CARTAS RESTANTES " + cartas);
                tvCaballeros = findViewById(R.id.CabRest);
                tvCaballeros.setText("CABALLEROS RESTANTES " + Caballeros);

                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                break;
            case "intermedio":
                flechas = 48;
                hordas = 12;
                tvFelchas = findViewById(R.id.ttv1);
                tvFelchas.setText("FLECHAS " + 48);
                tvHordas = findViewById(R.id.ttv2);
                tvHordas.setText("HORDAS " + hordas);
                tvCartas = findViewById(R.id.tvCard);
                tvCartas.setText("CARTAS RESTANTES " + cartas);
                tvCaballeros = findViewById(R.id.CabRest);
                tvCaballeros.setText("CABALLEROS RESTANTES " + Caballeros);

                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                break;
            case "dificil":
                flechas = 45;
                hordas = 15;
                tvFelchas = findViewById(R.id.ttv1);
                tvFelchas.setText("FLECAHS " + flechas);
                tvHordas = findViewById(R.id.ttv2);
                tvHordas.setText("HORDAS " + hordas);
                tvCartas = findViewById(R.id.tvCard);
                tvCartas.setText("CARTAS RESTANTES " + cartas);
                tvCaballeros = findViewById(R.id.CabRest);
                tvCaballeros.setText("CABALLEROS RESTANTES " + Caballeros);

                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                break;
            default:
                flechas = 48;
                hordas = 12;
                tvFelchas = findViewById(R.id.ttv1);
                tvFelchas.setText("FLECHAS " + flechas);
                tvHordas = findViewById(R.id.ttv2);
                tvHordas.setText("HORDAS " + hordas);
                tvCartas = findViewById(R.id.tvCard);
                tvCartas.setText("CARTAS RESTANTES " + cartas);
                tvCaballeros = findViewById(R.id.CabRest);
                tvCaballeros.setText("CABALLEROS RESTANTES " + Caballeros);

                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(3);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(4);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                hordasOrcos.add(5);
                break;
        }


        Ronda = findViewById(R.id.SigRonda);
        Ronda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contRondas < 1) {

                    if (hordas > 0) {
                        Bengala = (Button) findViewById(R.id.Bengala);
                        Bengala.setEnabled(true);
                        contCaballero = 0;
                        contOrcos = 0;
                        contBengala = 0;
                        contMover = 0;
                        contMover2 = 0;
                        batalla = 0;
                        bFinal = 0;
                        contRondas = 2;
                        ronda=ronda+1;
                        CaballerosMetodo();
                        Toast.makeText(getApplicationContext(), "RONDA : " + ronda, Toast.LENGTH_SHORT).show();

                        //AZUL
                        bAzul = findViewById(R.id.bt1Azul);
                        bAzul.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Azul);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }); 

                        //ROJO
                        bRojo = findViewById(R.id.bt1Rojo);
                        bRojo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Rojo);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        //NARANJA
                        bNaranja = findViewById(R.id.bt1Naranja);
                        bNaranja.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Naranja);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                        //BLANCO
                        bBlanco = findViewById(R.id.bt1Blanco);
                        bBlanco.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Blanco);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                        //AMARILLO
                        bAmarillo = findViewById(R.id.bt1Amarillo);
                        bAmarillo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Amarillo);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                        //VERDE
                        bVerde = findViewById(R.id.bt1Verde);
                        bVerde.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Verde);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                        //MORADO
                        bMorado = findViewById(R.id.bt1Morado);
                        bMorado.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (contCaballero < 1) {
                                    addcaballero(Morado);
                                    Caballeros=Caballeros-1;
                                    Actualizar();
                                    contCaballero = 2;
                                } else {
                                    Toast.makeText(getApplicationContext(), "YA HAS COLOCADO UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        //poner orcos
                        ponerOrcos = findViewById(R.id.ponerOrco);
                        ponerOrcos.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                            public void onClick(View view) {
                                if (contCaballero > 1) {
                                    if (contOrcos < 1) {

                                        for (int i= 0; i < 3; i++){
                                            //Random r = new Random();
                                            int r = ThreadLocalRandom.current().nextInt(1, 7);

                                            if (r == 1){
                                                if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }
                                            }

                                            if (r == 2){
                                                if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }

                                            }
                                            if (r == 3){
                                                if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }

                                            }
                                            if (r == 4){
                                                if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }
                                            }
                                            if (r == 5){
                                                if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }
                                            }
                                            if (r == 6){
                                                if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }
                                            }
                                            if (r == 7){
                                                if(Naranja.getSector() == "VIVO"){
                                                    Naranja.setOrcos(Naranja.getOrcos()+1);
                                                }else if(Morado.getSector() == "VIVO"){
                                                    Morado.setOrcos(Morado.getOrcos()+1);
                                                }else if(Blanco.getSector() == "VIVO"){
                                                    Blanco.setOrcos(Blanco.getOrcos()+1);
                                                }else if(Azul.getSector() == "VIVO"){
                                                    Azul.setOrcos(Azul.getOrcos()+1);
                                                }else if(Rojo.getSector() == "VIVO"){
                                                    Rojo.setOrcos(Rojo.getOrcos()+1);
                                                }else if(Amarillo.getSector() == "VIVO"){
                                                    Amarillo.setOrcos(Amarillo.getOrcos()+1);
                                                }else if(Verde.getSector() == "VIVO"){
                                                    Verde.setOrcos(Verde.getOrcos()+1);
                                                }
                                            }
                                        }

                                        Actualizar();
                                        contOrcos = 2;
                                    } else {
                                        Toast.makeText(getApplicationContext(), "YA HAS COLOCADO LOS ORCOS", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "PRIMERO DEBES COLOCAR UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        //BENGALA
                        Bengala = findViewById(R.id.Bengala);
                        Bengala.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {

                                if (contCaballero == 2) {
                                    if (contOrcos == 2) {
                                        BAtacar = (Button) findViewById(R.id.BengAtacar);
                                        BAtacar.setEnabled(true);
                                        BPasar = (Button) findViewById(R.id.BengPasar);
                                        BPasar.setEnabled(true);
                                        BMover = (Button) findViewById(R.id.BengMover);
                                        BMover.setEnabled(true);

                                    } else {
                                        Toast.makeText(getApplicationContext(), "DEBES COLOCAR LOS ORCOS", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getApplicationContext(), "1º DEBES COLOCAR UN CABALLERO", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                        BAtacar = findViewById(R.id.BengAtacar);
                        BAtacar.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "ELIGE UN TERRITORIO PARA ATACAR", Toast.LENGTH_SHORT).show();

                                Button bA = findViewById(R.id.bt2Azul);
                                bA.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Azul);
                                        BengalaAtacar(Azul);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bR = findViewById(R.id.bt2Rojo);
                                bR.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Rojo);
                                        BengalaAtacar(Rojo);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bN = findViewById(R.id.bt2Naranja);
                                bN.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Naranja);
                                        BengalaAtacar(Naranja);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bB = findViewById(R.id.bt2Blanco);
                                bB.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Blanco);
                                        BengalaAtacar(Blanco);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bAm = findViewById(R.id.bt2Amarillo);
                                bAm.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Amarillo);
                                        BengalaAtacar(Amarillo);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bV = findViewById(R.id.bt2Verde);
                                bV.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Verde);
                                        BengalaAtacar(Verde);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                                Button bM = findViewById(R.id.bt2Morado);
                                bM.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        contFlechas(Morado);
                                        BengalaAtacar(Morado);
                                        cartas = cartas - 1;
                                        Actualizar();
                                        contBengala = contBengala + 1;
                                        batalla = batalla + 1;
                                        if (contBengala > 1) {
                                            Bengala = (Button) findViewById(R.id.Bengala);
                                            Bengala.setEnabled(false);
                                            BAtacar = (Button) findViewById(R.id.BengAtacar);
                                            BAtacar.setEnabled(false);
                                            BPasar = (Button) findViewById(R.id.BengPasar);
                                            BPasar.setEnabled(false);
                                            BMover = (Button) findViewById(R.id.BengMover);
                                            BMover.setEnabled(false);
                                        }
                                    }
                                });
                            }
                        });

                        //PASAR TURNO
                        BPasar = findViewById(R.id.BengPasar);
                        BPasar.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "HAS PASADO TURNO", Toast.LENGTH_SHORT).show();
                                cartas = cartas - 1;
                                Actualizar();
                                contBengala = contBengala + 1;
                                batalla = batalla + 1;
                                if (contBengala > 1) {
                                    Bengala = (Button) findViewById(R.id.Bengala);
                                    Bengala.setEnabled(false);
                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                    BAtacar.setEnabled(false);
                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                    BPasar.setEnabled(false);
                                    BMover = (Button) findViewById(R.id.BengMover);
                                    BMover.setEnabled(false);
                                }
                            }
                        });

                        //MOVER CABALLERO
                        BMover = findViewById(R.id.BengMover);
                        BMover.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "VAS A MOVER UN CABALLERO", Toast.LENGTH_SHORT).show();
                                contCaballero = 0;
                                if (contMover < 1) {
                                    Button bA = findViewById(R.id.bt2Azul);
                                    bA.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Azul);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                if (contMover < 1) {
                                    Button bR = findViewById(R.id.bt2Rojo);
                                    bR.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Rojo);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                if (contMover < 1) {
                                    Button bN = findViewById(R.id.bt2Naranja);
                                    bN.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Naranja);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                if (contMover < 1) {
                                    Button bB = findViewById(R.id.bt2Blanco);
                                    bB.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Blanco);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                if (contMover < 1) {
                                    Button bAm = findViewById(R.id.bt2Amarillo);
                                    bAm.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Amarillo);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }


                                if (contMover < 1) {
                                    Button bV = findViewById(R.id.bt2Verde);
                                    bV.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Verde);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                if (contMover < 1) {
                                    Button bM = findViewById(R.id.bt2Morado);
                                    bM.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moverCaballero(Morado);
                                            Actualizar();
                                            contMover = 2;
                                            Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    Toast.makeText(getApplicationContext(), "AHORA DEBES ELEGIR EL TERRITORIO PARA QUE VIAJE EL CABALLERO", Toast.LENGTH_SHORT).show();
                                }

                                //
                                if (contMover > 1) {
                                    if (contMover2 < 1) {
                                        Button bA2 = findViewById(R.id.bt1Azul);
                                        bA2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Azul);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bR2 = findViewById(R.id.bt1Rojo);
                                        bR2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Rojo);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bN2 = findViewById(R.id.bt1Naranja);
                                        bN2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Naranja);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bB2 = findViewById(R.id.bt1Blanco);
                                        bB2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Blanco);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bAm2 = findViewById(R.id.bt1Amarillo);
                                        bAm2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Amarillo);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bV2 = findViewById(R.id.bt1Verde);
                                        bV2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Verde);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }
                                    if (contMover2 < 1) {
                                        Button bM2 = findViewById(R.id.bt1Morado);
                                        bM2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if (contCaballero < 1) {
                                                    addcaballero(Morado);
                                                    cartas = cartas - 1;
                                                }
                                                Actualizar();
                                                contMover2 = 2;
                                                contBengala = contBengala + 1;
                                                contCaballero = 2;
                                                batalla = batalla + 1;
                                                if (contBengala > 1) {
                                                    Bengala = (Button) findViewById(R.id.Bengala);
                                                    Bengala.setEnabled(false);
                                                    BAtacar = (Button) findViewById(R.id.BengAtacar);
                                                    BAtacar.setEnabled(false);
                                                    BPasar = (Button) findViewById(R.id.BengPasar);
                                                    BPasar.setEnabled(false);
                                                    BMover = (Button) findViewById(R.id.BengMover);
                                                    BMover.setEnabled(false);
                                                }
                                            }
                                        });
                                    }

                                }//if1

                            }//MOVER
                        });

                        //BATALLA FINAL
                        final Button bBFinal = findViewById(R.id.bFinal);
                        bBFinal.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (batalla > 1) {
                                    if (bFinal < 1) {
                                        Toast.makeText(getApplicationContext(), "FASE FINAL: GUERREROS Y ORCOS VAN A LUCHAR!!", Toast.LENGTH_SHORT).show();
                                        batallaFinal(Azul);
                                        batallaFinal(Rojo);
                                        batallaFinal(Naranja);
                                        batallaFinal(Blanco);
                                        batallaFinal(Amarillo);
                                        batallaFinal(Verde);
                                        batallaFinal(Morado);
                                        //
                                        sectorMuerto(Azul);
                                        sectorMuerto(Rojo);
                                        sectorMuerto(Naranja);
                                        sectorMuerto(Blanco);
                                        sectorMuerto(Amarillo);
                                        sectorMuerto(Verde);
                                        sectorMuerto(Morado);

                                        Actualizar();
                                        bFinal = 2;
                                        contRondas = 0;

                                        if(Azul.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Azul);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Azul);
                                            b2.setEnabled(false);
                                        }
                                        if(Rojo.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Rojo);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Rojo);
                                            b2.setEnabled(false);
                                        }
                                        if(Amarillo.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Amarillo);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Amarillo);
                                            b2.setEnabled(false);
                                        }
                                        if(Verde.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Verde);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Verde);
                                            b2.setEnabled(false);
                                        }
                                        if(Blanco.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Blanco);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Blanco);
                                            b2.setEnabled(false);
                                        }
                                        if(Naranja.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Naranja);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Naranja);
                                            b2.setEnabled(false);
                                        }
                                        if(Morado.getSector() == "MUERTO"){
                                            Button b = (Button) findViewById(R.id.bt1Morado);
                                            b.setEnabled(false);
                                            Button b2 = (Button) findViewById(R.id.bt2Morado);
                                            b2.setEnabled(false);
                                        }

                                        if(Azul.getSector() == "MUERTO" && Rojo.getSector() == "MUERTO" && Amarillo.getSector() == "MUERTO" && Verde.getSector() == "MUERTO" && Blanco.getSector() == "MUERTO" && Naranja.getSector() == "MUERTO" && Morado.getSector() == "MUERTO"){
                                            Menu = (Button) findViewById(R.id.volver);
                                            Menu.setEnabled(true);
                                            Toast.makeText(getApplicationContext(), "DERROTA, TODOS LOS TERRITORIOS HAS SIDO CONQUISTADOS", Toast.LENGTH_SHORT).show();
                                            Button Menu = findViewById(R.id.volver);
                                            Menu.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent(Juego.this, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            });
                                        }

                                        if (hordas == 0){
                                            Menu = (Button) findViewById(R.id.volver);
                                            Menu.setEnabled(true);
                                            Toast.makeText(getApplicationContext(), "VICTORIA!, HAS SOBREVIVIDO A TODAS LAS HORDAS", Toast.LENGTH_SHORT).show();
                                            Button Menu = findViewById(R.id.volver);
                                            Menu.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent intent = new Intent(Juego.this, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            });

                                        }
                                    }

                                    Toast.makeText(getApplicationContext(), "LOS GUERREROS Y ORCOS YA HAN LUCHADO", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), "AUN NO ESTAS LISTO PARA LA BATALLA FINAL", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        hordas = hordas - 1;
                        Mazo();
                        Actualizar();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "AUN NO PUEDES PASAR DE RONDA", Toast.LENGTH_SHORT).show();
                }
            }
            });


    }//onCreate


    public void addcaballero(Territorio T){
        T.setCaballero(T.getCaballero()+1);
    }

    public void addOrcos2(Territorio T) {
        if (T.getSector() == "VIVO") {
            T.setOrcos(T.getOrcos() + 1);
        }
    }

    public void BengalaAtacar(Territorio T){
        if(T.getOrcos() > 0){
            T.setOrcos(T.getOrcos()-1);
        }
        if(T.getCaballero() > 0){
            T.setCaballero(T.getCaballero()-1);
        }
    }

    public void moverCaballero(Territorio T){
        if(T.getCaballero() > 0){
            T.setCaballero(T.getCaballero()-1);
        }
    }

    public void batallaFinal(Territorio T){

        if(T.getOrcos() >= 1 && T.getCaballero() >= 1 ) {

            int n1 = T.getCaballero();
            int n2 = T.getOrcos();

            if( T.getOrcos() == T.getCaballero() ) {
                T.setCaballero(n1-n2);
                T.setOrcos(n2-n1);
            }

            if( T.getOrcos() < T.getCaballero() ) {
                T.setCaballero(n1-n2);
                T.setOrcos(n2-n1);
                if( T.getOrcos() < 1){
                    T.setOrcos(0);
                }
                if( T.getCaballero() < 1){
                    T.setCaballero(0);
                }
            }

            if( T.getOrcos() > T.getCaballero() ) {
                T.setCaballero(n1-n2);
                T.setOrcos(n2-n1);
                if( T.getOrcos() < 1){
                    T.setOrcos(0);
                }
                if( T.getCaballero() < 1){
                    T.setCaballero(0);
                }
            }

        }

    }

    public void sectorMuerto(Territorio T){
        if(T.getOrcos() >=3){
            T.setSector("MUERTO");
        }
    }
    
    public void contFlechas(Territorio T){
        if(T.getOrcos() > 0 && T.getCaballero() > 0){
            flechas=flechas-2;
        }else if(T.getOrcos() > 0 && T.getCaballero() == 0){
            flechas=flechas-1;
        }else if(T.getOrcos() == 0 && T.getCaballero() > 0){
            flechas=flechas-1;
        }else{
            flechas=flechas;
        }
    }

    public void Mazo(){
        if(cartas<=0){
            Bengala = (Button) findViewById(R.id.Bengala);
            Bengala.setEnabled(false);
            BAtacar = (Button) findViewById(R.id.BengAtacar);
            BAtacar.setEnabled(false);
            BPasar = (Button) findViewById(R.id.BengPasar);
            BPasar.setEnabled(false);
            BMover = (Button) findViewById(R.id.BengMover);
            BMover.setEnabled(false);
        }
    }

    public void CaballerosMetodo(){
        if (Caballeros <= 0){
            contCaballero=2;
        }
    }

    public void Actualizar(){
        tvAzul.setText("Sector "+ Azul.getSector()+"\n"+"Caballeros "+ Azul.getCaballero()+"\n"+"Orcos "+ Azul.getOrcos());
        tvRojo.setText("Sector "+ Rojo.getSector()+"\n"+"Caballeros "+ Rojo.getCaballero()+"\n"+"Orcos "+ Rojo.getOrcos());
        tvNaranja.setText("Sector "+ Naranja.getSector()+"\n"+"Caballeros "+ Naranja.getCaballero()+"\n"+"Orcos "+ Naranja.getOrcos());
        tvBlanco.setText("Sector "+ Blanco.getSector()+"\n"+"Caballeros "+ Blanco.getCaballero()+"\n"+"Orcos "+ Blanco.getOrcos());
        tvAmarillo.setText("Sector "+ Amarillo.getSector()+"\n"+"Caballeros "+ Amarillo.getCaballero()+"\n"+"Orcos "+ Amarillo.getOrcos());
        tvVerde.setText("Sector "+ Verde.getSector()+"\n"+"Caballeros "+ Verde.getCaballero()+"\n"+"Orcos "+ Verde.getOrcos());
        tvMorado.setText("Sector "+ Morado.getSector()+"\n"+"Caballeros "+ Morado.getCaballero()+"\n"+"Orcos "+ Morado.getOrcos());
        tvFelchas.setText("FLECHAS "+flechas);
        tvCartas.setText("CARTAS RESTANTES "+cartas);
        tvHordas.setText("HORDAS RESTANTES "+hordas);
        tvCaballeros.setText("CABALLEROS RESTANTES " + Caballeros);
    }

}