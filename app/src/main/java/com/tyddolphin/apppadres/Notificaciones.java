package com.tyddolphin.apppadres;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Gianella Milon on 02/06/2017.
 */

/*public class Notificaciones {
    private int id;
    private String name;
    private String alert;
    public int color;

    public Notificaciones(){
        super();
    }
    public Notificaciones(int id, String name, String alert, int color) {
        super();
        this.id = id;
        this.name = name;
        this.alert = alert;
        this.color= color;
    }
    @Override
    public String toString() {
        return "Movilidad " + this.id + " : " + this.name + " |" + " Alerta : " + this.alert;
    }
}*/
public class Notificaciones  {
    int id;
    Context contexto;
    Class Clase;
    String Title;
    String ContentText;
    String TextoGrande;



    public Notificaciones(int i,Context c, Class cl, String t, String CT, String TG){
        id = i;
        contexto = c;
        Clase = cl;
        Title = t;
        ContentText = CT;
        TextoGrande = TG;
        GenerarNotificacion();
    }

    public void GenerarNotificacion(){
        long[] vibrate = { 0, 100, 200, 300 };
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(contexto, Clase);
        PendingIntent pendingIntent = PendingIntent.getActivity(contexto, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(contexto);
        builder.setSmallIcon(R.drawable.ic_directions_bus_black_36dp);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(contexto.getResources(), R.drawable.icono));
        builder.setContentTitle(Title);
        builder.setContentText(ContentText);
        builder.setVibrate(vibrate);
        builder.setSound(alarmSound);
        if(TextoGrande != ""){
            builder.setStyle(new NotificationCompat.BigTextStyle()
                    .bigText(ContentText+"\n" +TextoGrande));
        }
        NotificationManager notificationManager = (NotificationManager) contexto.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(id,builder.build());
    }


}
