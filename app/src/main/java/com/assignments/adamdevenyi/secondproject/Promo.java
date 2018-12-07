package com.assignments.adamdevenyi.secondproject;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Promo extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary myLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        myLibrary = GestureLibraries.fromRawResource(this.R.raw.gestures);
        if (myLibrary.load() == false){
            finish();
        }
        GestureOverlayView gestures = (GestureOverlayView)findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

    }
}
