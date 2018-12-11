/*
 * Adam Devenyi
 * R00155710
 * adam.devenyi@mycit.ie
 *
 * */
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

    private static final String ORDER_CHANNEL_ID = "Order Channel";
    private static final String ORDER_CHANNEL_NAME = "Order";
    private static final String ARRIVED_CHANNEL_ID = "Arrived Channel";
    private static final String ARRIVED_CHANNEL_NAME = "Arrived";
    private NotificationManager manager;
    private Order myOrder;


    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannels();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel orderChannel =
                new NotificationChannel(ORDER_CHANNEL_ID, ORDER_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        orderChannel.enableLights(true);
        orderChannel.enableVibration(true);
        orderChannel.setLightColor(Color.GREEN);
        orderChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(orderChannel);

        NotificationChannel arrivedChannel =
                new NotificationChannel(ARRIVED_CHANNEL_ID, ARRIVED_CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        arrivedChannel.enableLights(true);
        arrivedChannel.enableVibration(true);
        arrivedChannel.setLightColor(Color.RED);
        arrivedChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(arrivedChannel);
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

    public NotificationCompat.Builder getOrderNotification(String title, String message){
        myOrder = MainActivity.getMyOrder();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0210000001"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), ORDER_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)                                                   //add icon
                .setContentTitle(title)                                                                    //add users title
                .setContentText(message)                                                                   //add users message
                .setStyle(new NotificationCompat.BigTextStyle()                                            //makes notification expandable
                        .bigText(myOrder.toString())                                                        //adds text when expanded
                        .setBigContentTitle("Expanded content")                                            //title of expanded notification
                        .setSummaryText("Summery"))                                                        //adds summery
                .setPriority(NotificationCompat.PRIORITY_HIGH)                                             //set priority to high by default
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)                                          //set category message
                .setContentIntent(pendingIntent)                                                           //calls when notification pressed
                .setColor(Color.GREEN)                                                                     //set colour
                .addAction(R.mipmap.ic_launcher, "Call", pendingIntent)                               //creates call button and calls when pressed
                .setAutoCancel(true);
    }

    public NotificationCompat.Builder getArrivedNotification(String title, String message){
        myOrder = MainActivity.getMyOrder();
        Intent intent = new Intent(NotificationHelper.this, PizzaArrived.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        return new NotificationCompat.Builder(getApplicationContext(), ARRIVED_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)                                                   //add icon
                .setContentTitle(title)                                                                    //add users title
                .setContentText(message)                                                                   //add users message
                .setStyle(new NotificationCompat.BigTextStyle()                                            //makes notification expandable
                        .bigText("ENJOY\nThank you for choosing BEST PIZZA!!!\n" +
                                "Get 5% off of your next order by drawing a circle at the promo code page!")//adds text when expanded
                        .setBigContentTitle("Expanded content")                                            //title of expanded notification
                        .setSummaryText("Summery"))                                                        //adds summery
                .setPriority(NotificationCompat.PRIORITY_MAX)                                             //set priority to high by default
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)                                          //set category message
                .setContentIntent(pendingIntent)                                                           //calls when notification pressed
                .setColor(Color.RED)                                                                     //set colour
                .addAction(R.mipmap.ic_launcher, "EAT", pendingIntent)                               //creates call button and calls when pressed
                .setAutoCancel(true);
    }
}
