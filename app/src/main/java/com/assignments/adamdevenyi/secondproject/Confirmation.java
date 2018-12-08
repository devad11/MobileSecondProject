package com.assignments.adamdevenyi.secondproject;

import android.Manifest;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;


import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.support.v4.app.NotificationCompat.PRIORITY_MAX;
import static com.assignments.adamdevenyi.secondproject.CreateChannel.CHANNEL_1_ID;
import static com.assignments.adamdevenyi.secondproject.CreateChannel.CHANNEL_2_ID;


public class Confirmation extends AppCompatActivity {

    private TextView phoneChoicetextView, addressChoicetextView, nameChoicetextView, priceChoicetextView, timeChoicetextView, orderTypeChoiceTextView, shopChoicetextView;
    private Order myOrder;
    private String currentTime;
    private Calendar calendar;
    private NotificationManagerCompat notificationManager;


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
        if (myOrder.getOrderType().equals("Collect")) {
            timeChoicetextView.setText(currentTime);
        } else if (myOrder.getOrderType().equals("ASAP Delivery")) {
            calendar.add(Calendar.MINUTE, 20);
            currentTime = df.format(calendar.getTime());
            timeChoicetextView.setText(currentTime);
        } else {
            timeChoicetextView.setText(myOrder.getDeliveryTime().toString());
        }

        notificationManager = NotificationManagerCompat.from(this);

    }
        public void sendNotification(View v){
        System.out.println("WWWWHHHHYYYYYYYYY");
            String title = "Best Pizza";      //gets title from user
            String message = "Thank you for your order";  //gets message form user

            Intent call = new Intent(Intent.ACTION_CALL);           //create an intent to make phone call
            call.setData(Uri.parse("tel:021 0000001"));             //add the phone number to the intent

            //checks for permisson, if there was no permission ask the user
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                return;
            }

            //create pending intent to be able to add to notification
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, call, 0);

            Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)  //build notification on channel 1
                    .setSmallIcon(R.mipmap.ic_launcher)                                             //add icon
                    .setContentTitle(title)                                                                    //add users title
                    .setContentText(message)                                                                   //add users message
                    .setStyle(new NotificationCompat.BigTextStyle()                                            //makes notification expandable
                            .bigText("lkjhgfdoiuytr njnbvfghjfg")                                             //adds text when expanded
                            .setBigContentTitle("Expanded content")                                            //title of expanded notification
                            .setSummaryText("Summery"))                                                        //adds summery
                    .setPriority(NotificationCompat.PRIORITY_HIGH)                                             //set priority to high by default
                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)                                          //set category message
                    .setContentIntent(pendingIntent)                                                           //calls when notification pressed
                    .setColor(Color.GREEN)                                                                     //set colour
                    .addAction(R.mipmap.ic_launcher_round, "Call", pendingIntent)                               //creates call button and calls when pressed
                    .setAutoCancel(true)                                                                       //set to cancel
                    .build();                                                                                  //create the notification
            notificationManager.notify(1, notification);                                                   //add the notification to channel 1
        }
}
