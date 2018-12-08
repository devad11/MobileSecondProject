package com.assignments.adamdevenyi.secondproject;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class BackgroundService extends IntentService {

    NotificationHelper notificationHelper;

    public BackgroundService() {
        super("BackgroundService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public BackgroundService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent( Intent intent) {

        try {

            Thread.sleep(10000);
            notificationHelper = new NotificationHelper(getApplicationContext());
            NotificationCompat.Builder builder = notificationHelper.getTimerChannelNotification("TITLE", "CONTENT");
            notificationHelper.getManager().notify(1, builder.build());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
