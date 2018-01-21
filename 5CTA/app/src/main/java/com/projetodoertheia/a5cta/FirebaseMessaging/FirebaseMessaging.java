package com.projetodoertheia.a5cta.FirebaseMessaging;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.projetodoertheia.a5cta.NoticiasFirebase.NoticiasActivity;
import com.projetodoertheia.a5cta.R;

/**
 * Created by Marcos on 09/09/2016.
 */
public class FirebaseMessaging extends FirebaseMessagingService{

    public static final String TAG = "NOTICIAS";


    @Override
    //Estando em background ou não!
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        String from = remoteMessage.getFrom();
        Log.d(TAG, "Mensagem recebida de: " + from);

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
//        if (remoteMessage.getData().size() &gt; 0) {
//            &nbsp; &nbsp;Log.d(TAG, "Message data payload: " + remoteMessage.getData());
//        }
    }

    private void sendNotification(String messageBody) {
        Intent intent = new Intent(this, NoticiasActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_cast_light)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());







//        if (remoteMessage.getNotification()!= null)
//        {
//            Log.d(TAG, "Notification " + remoteMessage.getNotification().getBody());
//
//            mostraNotificacao(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
//
//        }
//
//        if (remoteMessage.getData().size()>0)
//        {
//            Log.d(TAG, "Data: " + remoteMessage.getData());
//        }



    }

//    private void mostraNotificacao(String title, String body) {
//
//
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 ,intent, PendingIntent.FLAG_ONE_SHOT);
//
//        Uri soundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//
//
//        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//                .setSmallIcon(R.drawable.ic_media_play)
//                .setContentTitle(title)
//                .setContentText(body)
//                .setAutoCancel(true)
//                .setSound(soundURI)
//                .setContentIntent(pendingIntent);
//
//        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notificationBuilder.build());
//    }

}
