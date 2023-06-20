package com.example.arquerasnand;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Territorio extends AppCompatActivity {

    String Nombre;
    int id;
    int Caballero;
    int Orcos;
    String Sector;

    public Territorio(String nombre, int id, int caballero, int orcos, String sector) {
        Nombre = nombre;
        this.id = id;
        Caballero = caballero;
        Orcos = orcos;
        Sector = sector;
    }

    public String getNombre() {
        return Nombre;
    }
    public int getId() {
        return id;
    }
    public int getCaballero() {
        return Caballero;
    }
    public int getOrcos() {
        return Orcos;
    }
    public String getSector() {
        return Sector;
    }
    //
    public void setNombre(String nombre) {Nombre = nombre;}
    public void setId(int id) {
        this.id = id;
    }
    public void setCaballero(int caballero) {
        Caballero = caballero;
    }
    public void setOrcos(int orcos) {
        Orcos = orcos;
    }
    public void setSector(String sector) {
        Sector = sector;
    }






}
