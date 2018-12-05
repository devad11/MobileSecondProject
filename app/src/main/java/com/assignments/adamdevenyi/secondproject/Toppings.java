package com.assignments.adamdevenyi.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class Toppings extends AppCompatActivity {

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private GestureDetector mDetector;
    private ToggleButton hamToggleButton, chickenToggleButton, mushroomToggleButton, pineappleToggleButton, sweetcornToggleButton, onionToggleButton;
    private SeekBar mySeekBar;
    private TextView pizzaTypeTextView, priceAmountTextView;
    private Order myOrder;
    private ArrayList<String> pizza;
    private Double price;
    private Double toppingPrice;
    private Double total;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        myOrder = MainActivity.getMyOrder();

        hamToggleButton = (ToggleButton) findViewById(R.id.hamToggleButton);
        chickenToggleButton = (ToggleButton) findViewById(R.id.chickenToggleButton);
        mushroomToggleButton = (ToggleButton) findViewById(R.id.mushroomToggleButton);
        pineappleToggleButton = (ToggleButton) findViewById(R.id.pineappleToggleButton);
        sweetcornToggleButton = (ToggleButton) findViewById(R.id.sweetcornToggleButton);
        onionToggleButton = (ToggleButton) findViewById(R.id.onionToggleButton);

        mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        mySeekBar.setProgress(2);
        pizzaTypeTextView = (TextView) findViewById(R.id.pizzaTypeTextView);
        final String[] size = {"7\"", "10\"", "12\"", "16\"", "19\""};

        price = 10.;
        toppingPrice = 0.;
        total = 0.;
        priceAmountTextView = (TextView) findViewById(R.id.priceAmountTextView);

        pizza = new ArrayList<String>();
        pizza.add("12\"");

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myOrder.toString().contains("null") || myOrder.toString().contains("")){
                    Toast.makeText(Toppings.this, "Enter all details", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (Toppings.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    System.out.println("no null");
                }
            }
        });

        hamToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("ham")){
                        pizza.add("ham");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("ham")){
                        pizza.remove("ham");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        hamToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("ham")){
                        pizza.add("ham");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("ham")){
                        pizza.remove("ham");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        pineappleToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("pineapple")){
                        pizza.add("pineapple");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("pineapple")){
                        pizza.remove("pineapple");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        chickenToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("chicken")){
                        pizza.add("chicken");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("chicken")){
                        pizza.remove("chicken");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        mushroomToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("mushroom")){
                        pizza.add("mushroom");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("mushroom")){
                        pizza.remove("mushroom");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        sweetcornToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("sweetcorn")){
                        pizza.add("sweetcorn");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("sweetcorn")){
                        pizza.remove("sweetcorn");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        onionToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("onion")){
                        pizza.add("onion");
                        toppingPrice = (toppingPrice + 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("onion")){
                        pizza.remove("onion");
                        toppingPrice = (toppingPrice - 0.50);
                        priceUpdate();
                        System.out.println(pizza);
                    }
                }
            }
        });

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pizzaTypeTextView.setText(size[progress]);
                pizza.set(0, size[progress]);
                switch (progress) {
                    case 0:
                        price = 5.;
                        break;
                    case 1:
                        price = 7.5;
                        break;
                    case 2:
                        price = 10.;
                        break;
                    case 3:
                        price = 12.;
                        break;
                    case 4:
                        price = 15.;
                        break;
                    default:
                        price = 0.;
                        break;
                }
                priceUpdate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH){
                    return false;
                }
                if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY){
                    finish();
                    return true;
                }
                return false;
            }
        });
    }
    public  boolean onTouchEvent(MotionEvent event){
        return mDetector.onTouchEvent(event);
    }
    private void priceUpdate(){
        total = toppingPrice + price;
        priceAmountTextView.setText(total.toString() + "€");
        myOrder.setPrice(total);
        myOrder.setPizza(pizza);
        System.out.println(myOrder.toString());
    }
}
