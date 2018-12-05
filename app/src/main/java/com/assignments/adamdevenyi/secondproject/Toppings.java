package com.assignments.adamdevenyi.secondproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
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
    private TextView pizzaTypeTextView;
    private ArrayList<String> pizza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toppings);

        hamToggleButton = (ToggleButton) findViewById(R.id.hamToggleButton);
        chickenToggleButton = (ToggleButton) findViewById(R.id.chickenToggleButton);
        mushroomToggleButton = (ToggleButton) findViewById(R.id.mushroomToggleButton);
        pineappleToggleButton = (ToggleButton) findViewById(R.id.pineappleToggleButton);
        sweetcornToggleButton = (ToggleButton) findViewById(R.id.sweetcornToggleButton);
        onionToggleButton = (ToggleButton) findViewById(R.id.onionToggleButton);

        mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        mySeekBar.setProgress(2);
        pizzaTypeTextView = (TextView) findViewById(R.id.pizzaTypeTextView);
        final String[] types = {"Crispy", "Extra Thin", "Thin", "Medium", "Thick"};

        pizza = new ArrayList<String>();

        hamToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    if( !pizza.contains("ham")){
                        pizza.add("ham");
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("ham")){
                        pizza.remove("ham");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("ham")){
                        pizza.remove("ham");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("pineapple")){
                        pizza.remove("pineapple");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("chicken")){
                        pizza.remove("chicken");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("mushroom")){
                        pizza.remove("mushroom");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("sweetcorn")){
                        pizza.remove("sweetcorn");
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
                        System.out.println(pizza);
                    }
                }
                else{
                    if( pizza.contains("onion")){
                        pizza.remove("onion");
                        System.out.println(pizza);
                    }
                }
            }
        });

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pizzaTypeTextView.setText(types[progress]);
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
}
