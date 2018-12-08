package com.assignments.adamdevenyi.secondproject;

import android.app.Notification;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PizzaArrived extends AppCompatActivity {

    Button mainButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_arrived);

        PizzaView pizzaView = new PizzaView(this);

        mainButton = (Button) findViewById(R.id.mainButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PizzaArrived.this, "OM NOM NOM", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PizzaArrived.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
