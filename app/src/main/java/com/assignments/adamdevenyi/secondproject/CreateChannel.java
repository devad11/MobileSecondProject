package com.assignments.adamdevenyi.secondproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class CreateChannel extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";


    @Override
    public void onCreate(){
        super.onCreate();
        createNotificationChannels();
    }

    //creates new channels if doesnt build ones yet
    private void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_1_ID, "Channel 1", NotificationManager.IMPORTANCE_HIGH);        //create channel 1
            channel.setDescription("This is channel 1");

            NotificationChannel channe2 = new NotificationChannel(
                    CHANNEL_2_ID, "Channel 2", NotificationManager.IMPORTANCE_HIGH);        //create channel 2
            channe2.setDescription("This is channel 2");

            //create and add notification manager to channels
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channe2);
        }
    }
}
