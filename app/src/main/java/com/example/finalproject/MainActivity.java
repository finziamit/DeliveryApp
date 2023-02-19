package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SearchView searchView;
    Button addOrderButton;
    OrderAdapter orderAdapter;

    MyDatabaseHelper myDB;
    ArrayList<String> orderSerialArr, orderedProductArr, orderDateArr, originArr, destArr, sendArr, arrivalArr, reciveArr, statusArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        addOrderButton = findViewById(R.id.addOrderButton);

        addOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddOrder.class);
                startActivity(intent);
            }
        });

        myDB = new MyDatabaseHelper(MainActivity.this);
        orderSerialArr = new ArrayList<>();
        orderedProductArr = new ArrayList<>();
        orderDateArr = new ArrayList<>();
        originArr = new ArrayList<>();
        destArr = new ArrayList<>();
        sendArr = new ArrayList<>();
        arrivalArr = new ArrayList<>();
        reciveArr = new ArrayList<>();
        statusArr = new ArrayList<>();

        storeDataInArrays();

        orderAdapter = new OrderAdapter(MainActivity.this, MainActivity.this, orderSerialArr,
                orderedProductArr, orderDateArr, originArr, destArr, statusArr);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                orderSerialArr.add(cursor.getString(0));
                orderedProductArr.add(cursor.getString(2));
                orderDateArr.add(cursor.getString(3));
                originArr.add(cursor.getString(4));
                destArr.add(cursor.getString(5));
                sendArr.add(cursor.getString(6));
                arrivalArr.add(cursor.getString(7));
                reciveArr.add(cursor.getString(8));
                statusArr.add(cursor.getString(9));
            }
        }

    }

    private void filterList(String text){
        ArrayList<String> orderSerialFilter = new ArrayList<>();
        ArrayList<String> orderedProductFilter = new ArrayList<>();
        ArrayList<String> orderDateFilter = new ArrayList<>();
        ArrayList<String> originFilter = new ArrayList<>();
        ArrayList<String> destFilter = new ArrayList<>();
        ArrayList<String> statusFilter = new ArrayList<>();
        for (int i=0;i<orderedProductArr.size();i++){
            if (orderedProductArr.get(i).toLowerCase().contains(text.toLowerCase())){
                orderSerialFilter.add(orderSerialArr.get(i));
                orderedProductFilter.add(orderedProductArr.get(i));
                orderDateFilter.add(orderDateArr.get(i));
                originFilter.add(originArr.get(i));
                destFilter.add(destArr.get(i));
                statusFilter.add(statusArr.get(i));
            }
        }
        if(orderSerialFilter.isEmpty()){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        else{
            orderAdapter.filterResults(orderSerialFilter, orderedProductFilter,
                    orderDateFilter, originFilter, destFilter, statusFilter);
        }
    }
}