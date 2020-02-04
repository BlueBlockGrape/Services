package com.example.servicios2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyService extends Service {
   /* public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }*/

    private NotificationManager notificationManager;
    private static final int ID_NOTIFICACION=1234;
    MediaPlayer mPlayer;
    String nombre;
    int numero=1;
    int param;
    int bloqueo=2;

    public MyService() {
    }





    @Override
    public void onCreate() {
        super.onCreate();

        notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        createNotificationChannel();
        Toast.makeText(this, "servicio creado", Toast.LENGTH_SHORT).show();

    }



    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("1223", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }




    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "servicio iniciado "+startId, Toast.LENGTH_SHORT).show();



        Bundle datos = intent.getExtras();
        if(datos != null) {
            nombre = datos.getString("nombre");
            param = datos.getInt("param");
            numero = datos.getInt("numero");
            Toast.makeText(this, "numero"+numero, Toast.LENGTH_SHORT).show();

        }

        switch (numero){
            case 1:
                mPlayer = MediaPlayer.create(this, R.raw.audio1);
                break;
            case 2:
                mPlayer = MediaPlayer.create(this, R.raw.pista01);
                break;
            case 3:
                mPlayer = MediaPlayer.create(this, R.raw.pista02);
                break;
            case 4:
                mPlayer = MediaPlayer.create(this, R.raw.pista03);
                break;
            case 5:
                mPlayer = MediaPlayer.create(this, R.raw.audio1);
                break;
            case 6:
                mPlayer = MediaPlayer.create(this, R.raw.pista01);
                break;
            case 7:
                mPlayer = MediaPlayer.create(this, R.raw.pista02);
                break;
            case 8:
                mPlayer = MediaPlayer.create(this, R.raw.pista03);
                break;
            case 9:
                mPlayer = MediaPlayer.create(this, R.raw.pista01);
                break;
        }
       // mPlayer = MediaPlayer.create(this, R.raw.audio1);
        mPlayer.start();

        //patron de vibracion

        long vibrate[] ={0,100,100};

     /*   NotificationCompat.Builder builder= new NotificationCompat.Builder(
                getBaseContext()).setSmallIcon(android.R.drawable.ic_dialog_info).setContentTitle("Musica")
                .setContentText("Servicio de Musica")
                .setVibrate(vibrate)
                .setWhen(System.currentTimeMillis());*/
        //lanzaria la notificacion



        // Create an explicit intent for an Activity in your app
        Intent intent1 = new Intent(this, reproductor.class);
        intent1.putExtra("nombre", nombre);
        intent1.putExtra("param", param);
        intent1.putExtra("numero", numero);
        intent1.putExtra("bloquea", bloqueo);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        //  PendingIntent pendingIntent = PendingIntent.getActivity(this,1, intent1, PendingIntent.FLAG_UPDATE_CURRENT);
       // startActivity(intent1);



        NotificationCompat.Builder builder1 = new NotificationCompat.Builder(this, "1223")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(nombre)
                .setContentText("Servicio Musica")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                // Set the intent that will fire when the user taps the notification
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        //notificationManager.notify(ID_NOTIFICACION, builder1.build());

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(ID_NOTIFICACION, builder1.build());


        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "servicio destruido", Toast.LENGTH_SHORT).show();
        mPlayer.stop();
        notificationManager.cancel(ID_NOTIFICACION);
    }


}
