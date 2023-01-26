package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShipmentDetails extends AppCompatActivity {

    private TextView orderSerialTV;
    private TextView shipmentSerialTV;
    private TextView orderDateTV;
    private TextView orderHourTV;
    private TextView locationTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipment_details);

        int orderSerial = getIntent().getIntExtra("number", 0);
        String orderDate = getIntent().getStringExtra("date");
        String hour = "12:22"; // hard coded

        orderSerialTV = findViewById(R.id.orderSerial);
        shipmentSerialTV = findViewById(R.id.shipmetSerial);
        orderDateTV = findViewById(R.id.orderDate);
        orderHourTV = findViewById(R.id.hour);
        locationTV = findViewById(R.id.location);

        orderSerialTV.setText(String.format("%03d", orderSerial));
        shipmentSerialTV.setText(String.format("%03d", orderSerial)); // need separation
        orderDateTV.setText(orderDate);
        orderHourTV.setText(hour); // hard coded
        locationTV.setText("Departed from origin country"); // hard coded
    }
}