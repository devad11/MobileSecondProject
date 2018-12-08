package com.assignments.adamdevenyi.secondproject;

import android.app.IntentService;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;

public class BackgroundService extends IntentService {

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
            System.out.println("DOne");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
