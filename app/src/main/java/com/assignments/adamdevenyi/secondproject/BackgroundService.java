/*
 * Adam Devenyi
 * R00155710
 * adam.devenyi@mycit.ie
 *
 * starts from Confirmation Activity
 * thread sleeps for 10 sec
 * sends notification
 * */
package com.assignments.adamdevenyi.secondproject;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

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
            NotificationCompat.Builder builder = notificationHelper.getArrivedNotification("Best Pizza", "Your Pizza arrived");
            notificationHelper.getManager().notify(2, builder.build());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
