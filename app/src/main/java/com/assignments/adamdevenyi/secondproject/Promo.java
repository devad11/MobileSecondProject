/*
 * Adam Devenyi
 * R00155710
 * adam.devenyi@mycit.ie
 *
 * */
package com.assignments.adamdevenyi.secondproject;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Promo extends AppCompatActivity implements GestureOverlayView.OnGesturePerformedListener {

    private GestureLibrary myLibrary;
    private Order myOrder;
    private Double oldPrice, newPrice;
    private Button OrderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promo);

        OrderInfo = (Button) findViewById(R.id.OrderInfo);
        OrderInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Promo.this, Confirmation.class);
                startActivity(intent);
            }
        });

        myLibrary = GestureLibraries.fromRawResource(this,R.raw.gestures);
        if (myLibrary.load() == false){
            finish();
        }
        GestureOverlayView gestures = (GestureOverlayView)findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {

        newPrice = 0.;
        myOrder = MainActivity.getMyOrder();
        oldPrice = myOrder.getPrice();

        ArrayList<Prediction> predictions = myLibrary.recognize(gesture);
        Collections.sort(predictions, new Comparator<Prediction>() {
                    @Override
                    public int compare(Prediction o1, Prediction o2) {
                        if (o1.score < o2.score){
                            return 1;
                        }
                        else if (o1.score > o2.score){
                            return -1;
                        }
                        else return 0;
                    }
        });
        if (predictions.get(0).name.equals("PromoCode")){
            Toast.makeText(Promo.this, "20% OFF", Toast.LENGTH_SHORT).show();
            newPrice = (oldPrice * 0.8);
            myOrder.setPrice(newPrice);
        }
        else if(predictions.get(0).name.equals("Pizza")){
            Toast.makeText(Promo.this, "5% OFF", Toast.LENGTH_SHORT).show();
            newPrice = (oldPrice * 0.95);
            myOrder.setPrice(newPrice);
        }
    }
}
