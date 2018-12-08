package com.assignments.adamdevenyi.secondproject;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TimePickerDialog.OnTimeSetListener {

    private TextView restaurantTextView, restaurantPickTextView;
    private Spinner spinner;
    //private String[] restaurants = {"Cork City Center Order", "Douglas Order"};

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private String typeText;
    private GestureDetector mDetector;
    private EditText nameEditText, addressEditText, pNumEditText;
    private TextView deliveryTimeTextView;
    public static Order myOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myOrder = new Order();

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        pNumEditText = (EditText) findViewById(R.id.pNumEditText);
        restaurantTextView = (TextView) findViewById(R.id.restaurantTextView);
        restaurantPickTextView = (TextView) findViewById(R.id.restaurantPickTextView);
        registerForContextMenu(restaurantPickTextView);
        registerForContextMenu(restaurantTextView);
        deliveryTimeTextView = (TextView) findViewById(R.id.deliveryTimeTextView);
        deliveryTimeTextView.setVisibility(deliveryTimeTextView.INVISIBLE);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH){
                    return false;
                }
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY){
                    myOrder.setAddress(addressEditText.getText().toString());
                    myOrder.setName(nameEditText.getText().toString());
                    myOrder.setpNum(pNumEditText.getText().toString());
                    myOrder.setShop(restaurantPickTextView.getText().toString());
                    myOrder.setOrderType(typeText);
                    if (typeText.equals("Delivery for later")){
                        myOrder.setDeliveryTime(deliveryTimeTextView.getText().toString());
                    }
                    if (addressEditText.getText().toString().equals("") || nameEditText.getText().toString().equals("") || pNumEditText.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Enter all details", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent intent = new Intent (MainActivity.this, Toppings.class);
                        startActivity(intent);
                    }

                    return true;
                }
                return false;
            }
        });
    }

    public  boolean onTouchEvent(MotionEvent event){
        return mDetector.onTouchEvent(event);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose restaurant");
        getMenuInflater().inflate(R.menu.restaurants, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.center:
                Toast.makeText(this, "City Center selected", Toast.LENGTH_SHORT).show();
                restaurantPickTextView.setText("City Center Pizza");
                return super.onContextItemSelected(item);
            case R.id.douglas:
                Toast.makeText(this, "Douglas selected", Toast.LENGTH_SHORT).show();
                restaurantPickTextView.setText("Douglas Pizza");
                return super.onContextItemSelected(item);
            case R.id.blackrock:
                Toast.makeText(this, "Blackrock selected", Toast.LENGTH_SHORT).show();
                restaurantPickTextView.setText("Blackrock Pizza");
                return super.onContextItemSelected(item);
            case R.id.wilton:
                Toast.makeText(this, "Wilton selected", Toast.LENGTH_SHORT).show();
                restaurantPickTextView.setText("Wilton Pizza");
                return super.onContextItemSelected(item);
                default:
                    return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        typeText = text;
        if (typeText.equals("Delivery for later")){
            selectTime();
        }
        else{
            deliveryTimeTextView.setVisibility(deliveryTimeTextView.INVISIBLE);
        }

        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void selectTime() {
        DialogFragment timePicker = new TimePickerFragment();
        timePicker.show(getSupportFragmentManager(), "time picker");
        deliveryTimeTextView.setVisibility(deliveryTimeTextView.VISIBLE);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        deliveryTimeTextView.setText("Delivery at " + hourOfDay + ":" + minute);
    }

    public static Order getMyOrder(){
        return myOrder;
    }

    public Context getContext(){
        return this.getContext();
    }
}
