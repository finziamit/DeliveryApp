package com.example.deliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderScreen extends AppCompatActivity {
    private TextView productTextView;
    private TextView serialTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_screen);

        Button orderDetails = (Button) findViewById(R.id.OrderDetails);

        String name = getIntent().getStringExtra("name");
        int number = getIntent().getIntExtra("number", 0);
        String date = getIntent().getStringExtra("date");
        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");
        String sent = getIntent().getStringExtra("sent");
        String arrived = getIntent().getStringExtra("arrival");
        String recived = getIntent().getStringExtra("recived");
        String status = getIntent().getStringExtra("status");

        productTextView = findViewById(R.id.order_product);
        serialTextView = findViewById(R.id.order_serial);


        productTextView.setText(name);
        serialTextView.setText(String.format("%03d",number)); // orders serials range - 000:999

        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout containerView = findViewById(R.id.list_ordered_item);


                Intent intent = new Intent(view.getContext(),order_details_screen.class);

                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("date", date);
                intent.putExtra("origin", origin);
                intent.putExtra("destination", destination);
                intent.putExtra("sent", sent);
                intent.putExtra("arrival", arrived);
                intent.putExtra("recived", recived);
                intent.putExtra("status",status);

                startActivity(intent);
            }
        });
    }
}