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
    private Order myOrder;

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
        NotificationChannel orderChannel =
                new NotificationChannel(TIMER_CHANNEL_ID, TIMER_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        orderChannel.enableLights(true);
        orderChannel.enableVibration(true);
        orderChannel.setLightColor(Color.GREEN);
        orderChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(orderChannel);
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
    public NotificationCompat.Builder getOrderNotification(String title, String message){
        myOrder = MainActivity.getMyOrder();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0210000001"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), TIMER_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)                                             //add icon
                .setContentTitle(title)                                                                    //add users title
                .setContentText(message)                                                                   //add users message
                .setStyle(new NotificationCompat.BigTextStyle()                                            //makes notification expandable
                        .bigText(myOrder.toString())                                             //adds text when expanded
                        .setBigContentTitle("Expanded content")                                            //title of expanded notification
                        .setSummaryText("Summery"))                                                        //adds summery
                .setPriority(NotificationCompat.PRIORITY_HIGH)                                             //set priority to high by default
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)                                          //set category message
                .setContentIntent(pendingIntent)                                                           //calls when notification pressed
                .setColor(Color.GREEN)                                                                     //set colour
                .addAction(R.mipmap.ic_launcher, "Call", pendingIntent)                               //creates call button and calls when pressed
                .setAutoCancel(true);
    }
}
