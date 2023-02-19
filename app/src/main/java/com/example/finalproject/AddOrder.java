package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddOrder extends AppCompatActivity {
    EditText productName, orderDate, originCountry, destinationCountry;
    Button addOrderBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        productName = findViewById(R.id.ProductName);
        orderDate = findViewById(R.id.OrderDate);
        originCountry = findViewById(R.id.OriginCountry);
        destinationCountry = findViewById(R.id.DestinationCountry);
        addOrderBtn = findViewById(R.id.addBtn);
        addOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddOrder.this);
                myDB.addOrder(productName.getText().toString().trim(),
                        orderDate.getText().toString().trim(),
                        originCountry.getText().toString().trim(),
                        destinationCountry.getText().toString().trim());
            }
        });
    }
}