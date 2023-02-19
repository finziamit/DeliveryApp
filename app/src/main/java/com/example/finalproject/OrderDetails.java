package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity {

    TextView product, serial, date, origin, dest, sent, arrival, recive, status;
    Button returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        product = findViewById(R.id.productName);
        serial = findViewById(R.id.orderSerial);
        date = findViewById(R.id.orderDate);
        origin = findViewById(R.id.countryOrigin);
        dest = findViewById(R.id.destinationCountry);
        sent = findViewById(R.id.sendingDate);
        arrival = findViewById(R.id.arrivalDate);
        recive = findViewById(R.id.orderReciveDate);
        status = findViewById(R.id.orderStatus);

        if(getIntent().hasExtra("Serial") && getIntent().hasExtra("Product") &&
                getIntent().hasExtra("Date") && getIntent().hasExtra("Origin") &&
                getIntent().hasExtra("Destination") &&
                getIntent().hasExtra("Status"))
        {
            product.setText(getIntent().getStringExtra("Product"));
            serial.setText(getIntent().getStringExtra("Serial"));
            date.setText(getIntent().getStringExtra("Date"));
            origin.setText(getIntent().getStringExtra("Origin"));
            dest.setText(getIntent().getStringExtra("Destination"));
            sent.setText(getIntent().getStringExtra("Date"));
            arrival.setText(getIntent().getStringExtra("Date"));
            recive.setText(getIntent().getStringExtra("Date"));
            status.setText(getIntent().getStringExtra("Status"));
        }

        returnBtn = findViewById(R.id.ExitButton2);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}