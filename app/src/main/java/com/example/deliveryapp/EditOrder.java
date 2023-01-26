package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditOrder extends AppCompatActivity {

    private String product;
    private String date;
    private String origin;
    private String destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        Button submit = (Button) findViewById(R.id.Submit);

        EditText productEditText = (EditText) findViewById(R.id.EditProduct);
        EditText dateEditText = (EditText) findViewById(R.id.orderDate);
        EditText originEditText = (EditText) findViewById(R.id.originCountry);
        EditText destinationEditText = (EditText) findViewById(R.id.destinationCountry);

        productEditText.setText(getIntent().getStringExtra("name"));
        dateEditText.setText(getIntent().getStringExtra("date"));
        originEditText.setText(getIntent().getStringExtra("origin"));
        destinationEditText.setText(getIntent().getStringExtra("destination"));

        product = (String)productEditText.toString();
        date = (String)dateEditText.toString();
        origin = (String)originEditText.toString();
        destination = (String)destinationEditText.toString();
    }
}