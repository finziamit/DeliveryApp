package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ShipmentDetails extends AppCompatActivity {
    TextView serial, shipmentSerial, date, hour, location;
    Button returnBtn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_details);

        serial = findViewById(R.id.orderSerial);
        shipmentSerial = findViewById(R.id.shipmetSerial);
        date = findViewById(R.id.orderDate);
        hour = findViewById(R.id.hour);
        location = findViewById(R.id.location);
        returnBtn = findViewById(R.id.ExitButton);

        if(getIntent().hasExtra("Serial") && getIntent().hasExtra("Date")){
            serial.setText(getIntent().getStringExtra("Serial"));
            shipmentSerial.setText(getIntent().getStringExtra("Serial"));
            date.setText(getIntent().getStringExtra("Date"));
            hour.setText("00:00");
            location.setText("Departed origin country");
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
            finish();
        }

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}