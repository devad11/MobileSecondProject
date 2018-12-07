package com.assignments.adamdevenyi.secondproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Confirmation extends AppCompatActivity {

    private TextView phoneChoicetextView, addressChoicetextView, nameChoicetextView, priceChoicetextView, timeChoicetextView, orderTypeChoiceTextView, shopChoicetextView;
    private Order myOrder;
    private String currentTime;
    private Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        myOrder = MainActivity.getMyOrder();

        DateFormat df = new SimpleDateFormat("hh:mm a");
        currentTime = df.format(Calendar.getInstance().getTime());

        try {
            Date date = df.parse(currentTime);
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MINUTE, 20);
            currentTime = df.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        phoneChoicetextView = (TextView) findViewById(R.id.phoneChoicetextView);
        addressChoicetextView = (TextView) findViewById(R.id.addressChoicetextView);
        nameChoicetextView = (TextView) findViewById(R.id.nameChoicetextView);
        priceChoicetextView = (TextView) findViewById(R.id.priceChoicetextView);
        timeChoicetextView = (TextView) findViewById(R.id.timeChoicetextView);
        orderTypeChoiceTextView = (TextView) findViewById(R.id.orderTypeChoiceTextView);
        shopChoicetextView = (TextView) findViewById(R.id.shopChoicetextView);

        phoneChoicetextView.setText(myOrder.getpNum().toString());
        addressChoicetextView.setText(myOrder.getAddress().toString());
        nameChoicetextView.setText(myOrder.getName().toString());
        priceChoicetextView.setText(String.format("%.2f", myOrder.getPrice()));
        orderTypeChoiceTextView.setText(myOrder.getOrderType().toString());
        shopChoicetextView.setText(myOrder.getShop().toString());
        if (myOrder.getOrderType().equals("Collect")){
            timeChoicetextView.setText(currentTime);
        }
        else if(myOrder.getOrderType().equals("ASAP Delivery")){
            calendar.add(Calendar.MINUTE, 20);
            currentTime = df.format(calendar.getTime());
            timeChoicetextView.setText(currentTime);
        }
        else{
            timeChoicetextView.setText(myOrder.getDeliveryTime().toString());
        }

    }
}