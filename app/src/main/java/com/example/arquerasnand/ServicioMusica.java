package com.example.arquerasnand;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServicioMusica extends Service {
    MediaPlayer reproductor;


    @Override
    public void onCreate(){

        reproductor = MediaPlayer.create( this, R.raw.audio);
    }
    @Override
    public int onStartCommand(Intent intenc, int flags, int idArranque){
        Toast.makeText(this, "Audio del juego activado"+ idArranque, Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this, "Audio del juego desactivado", Toast.LENGTH_SHORT).show();
        reproductor.stop();
        reproductor.release();
    }
    @Override
    public IBinder onBind(Intent intenc){
        return null;
    }
}

