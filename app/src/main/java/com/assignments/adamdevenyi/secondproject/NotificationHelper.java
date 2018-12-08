package com.assignments.adamdevenyi.secondproject;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;


public class NotificationHelper extends ContextWrapper {

    //-------------------------
    //      ATTRIBUTES
    //-------------------------
    private static final String TIMER_CHANNEL_ID = "Timer Channel";
    private static final String TIMER_CHANNEL_NAME = "Timer";
    private NotificationManager manager;

    //-------------------------
    //      CONSTRUCTORS
    //-------------------------
    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    //-------------------------
    //      METHODS
    //-------------------------

    /**
     * Method that creates a channel for phone notifications
     * only targets API level 26 or higher
     */
    @TargetApi(Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel timerChannel =
                new NotificationChannel(TIMER_CHANNEL_ID, TIMER_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        timerChannel.enableLights(true);
        timerChannel.enableVibration(true);
        timerChannel.setLightColor(Color.GREEN);
        timerChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(timerChannel);
    }

    /**
     * Getter for the associated Notification Manager
     * if ones not created yet it creates a new one
     * @return notification manager
     */
    public NotificationManager getManager() {
        if(this.manager == null)
            manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return this.manager;
    }

    /**
     *  Method that creates a new intent and associates it to the builder
     *  also associates the notification with a channel
     *
     * @param title String to become notification title
     * @param message String to become notification body
     * @return NotificationCompat.Builder with the pending intent
     */
    public NotificationCompat.Builder getTimerChannelNotification(String title, String message){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0210000001"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), TIMER_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);
    }
}
