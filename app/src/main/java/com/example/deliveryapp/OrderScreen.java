package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrderScreen extends AppCompatActivity {
    private TextView productTextView;
    private TextView serialTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number", 0);

        productTextView = findViewById(R.id.order_product);
        serialTextView = findViewById(R.id.order_serial);

        productTextView.setText(name);
        serialTextView.setText(String.format("%03d",number)); // orders serials range - 000:999
    }
}