package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddOrder extends AppCompatActivity {

    private int serialnumber = 0;
    private String product;
    private String date;
    private String origin;
    private String destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        // set button
        Button submit = (Button) findViewById(R.id.Submit);

        // get the content of the EditText
        EditText productEditText = (EditText) findViewById(R.id.AddProduct);
        EditText dateEditText = (EditText) findViewById(R.id.orderDate);
        EditText originEditText = (EditText) findViewById(R.id.originCountry);
        EditText destinationEditText = (EditText) findViewById(R.id.destinationCountry);

        product = (String)productEditText.toString();
        date = (String)dateEditText.toString();
        origin = (String)originEditText.toString();
        destination = (String)destinationEditText.toString();

        //onClick
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Order newOrder = new Order(serialnumber++, product, date, origin, destination);
                //TO-DO: add the new order to orders list (right now is hard coded in OrderAdapter)
                finish();
            }
        });
    }

}