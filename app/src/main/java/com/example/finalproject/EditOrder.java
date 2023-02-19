package com.example.finalproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditOrder extends AppCompatActivity {

    EditText productInput, dateInput, originInput, destinationInput;
    Button editButton, deleteButton, orderDetails, shipmentDetails;
    String serial, product, date, origin, destination, status;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);

        productInput = findViewById(R.id.ProductName2);
        dateInput = findViewById(R.id.OrderDate2);
        originInput = findViewById(R.id.OriginCountry2);
        destinationInput = findViewById(R.id.DestinationCountry2);

        editButton = findViewById(R.id.EditBtn);
        deleteButton = findViewById(R.id.DeleteBtn);
        orderDetails = findViewById(R.id.orderDetailsBtn);
        shipmentDetails = findViewById(R.id.shipmentDetailsBtn);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null){
            ab.setTitle(product);
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditOrder.this);
                myDB.editData(serial, productInput.getText().toString(),
                        dateInput.getText().toString(),
                        originInput.getText().toString(),
                        destinationInput.getText().toString());
                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("Serial") && getIntent().hasExtra("Product") &&
                        getIntent().hasExtra("Date") && getIntent().hasExtra("Origin") &&
                        getIntent().hasExtra("Destination") &&
                        getIntent().hasExtra("Status")) {
                    Intent intent = new Intent(v.getContext(), OrderDetails.class);
                    intent.putExtra("Serial", serial);
                    intent.putExtra("Product", getIntent().getStringExtra("Product"));
                    intent.putExtra("Date", date);
                    intent.putExtra("Origin", origin);
                    intent.putExtra("Destination", destination);
                    intent.putExtra("Status", getIntent().getStringExtra("Status"));

                    startActivity(intent);
                }
            }
        });

        shipmentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().hasExtra("Serial") &&
                        getIntent().hasExtra("Date") && getIntent().hasExtra("Origin") &&
                        getIntent().hasExtra("Destination")) {
                    Intent intent = new Intent(v.getContext(), ShipmentDetails.class);
                    intent.putExtra("Serial", serial);
                    intent.putExtra("Date", date);
                    intent.putExtra("Origin", origin);
                    intent.putExtra("Destination", destination);

                    startActivity(intent);
                }
            }
        });
    }

    void getAndSetIntentData(){
        if (getIntent().hasExtra("Serial") && getIntent().hasExtra("Product") &&
                getIntent().hasExtra("Date") && getIntent().hasExtra("Origin") &&
                getIntent().hasExtra("Destination"))
        {
            serial = getIntent().getStringExtra("Serial");
            product = getIntent().getStringExtra("Product");
            date = getIntent().getStringExtra("Date");
            origin = getIntent().getStringExtra("Origin");
            destination = getIntent().getStringExtra("Destination");

            productInput.setText(product);
            dateInput.setText(date);
            originInput.setText(origin);
            destinationInput.setText(destination);
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + product + " ?");
        builder.setMessage("Are you sure you want to delete " + product + "?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(EditOrder.this);
                myDB.deleteOneRow(serial);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}