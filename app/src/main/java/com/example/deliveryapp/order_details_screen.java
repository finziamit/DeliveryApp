package com.example.deliveryapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class order_details_screen extends AppCompatActivity {

    private TextView productName;
    private TextView orderSerial;
    private TextView orderDate;
    private TextView countryOrigin;
    private TextView destinationCountry;
    private TextView sendingDate;
    private TextView arrivalDate;
    private TextView orderReciveDate;
    private TextView statusTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_screen);

        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number", 0);
        String date = getIntent().getStringExtra("date");
        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");
        String sent = getIntent().getStringExtra("sent");
        String arrived = getIntent().getStringExtra("arrival");
        String recived = getIntent().getStringExtra("recived");
        String status = getIntent().getStringExtra("status");

        // match each TextView to the right one
        productName = findViewById(R.id.productName);
        orderSerial = findViewById(R.id.orderSerial);
        orderDate = findViewById(R.id.orderDate);
        countryOrigin = findViewById(R.id.countryOrigin);
        destinationCountry = findViewById(R.id.destinationCountry);
        sendingDate = findViewById(R.id.sendingDate);
        arrivalDate = findViewById(R.id.arrivalDate);
        orderReciveDate = findViewById(R.id.orderReciveDate);
        statusTV = findViewById(R.id.orderStatus);

        // set the order details in the textviews
        productName.setText(name);
        orderSerial.setText(String.format("%03d",number));
        orderDate.setText(date);
        countryOrigin.setText(origin);
        destinationCountry.setText(destination);
        sendingDate.setText(sent);
        arrivalDate.setText(arrived);
        orderReciveDate.setText(recived);
        statusTV.setText(status);

    }
}