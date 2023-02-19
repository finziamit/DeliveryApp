package com.example.finalproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList orderSerialArr, orderedProductArr, orderDateArr, originArr, destArr, statusArr;

    OrderAdapter(Activity activity,
                 Context context,
                 ArrayList orderSerialArr,
                 ArrayList orderedProductArr,
                 ArrayList orderDateArr,
                 ArrayList originArr,
                 ArrayList destArr,
                 ArrayList statusArr){
        this.activity = activity;
        this.context = context;
        this.orderSerialArr = orderSerialArr;
        this.orderedProductArr = orderedProductArr;
        this.orderDateArr = orderDateArr;
        this.originArr = originArr;
        this.destArr = destArr;
        this.statusArr = statusArr;
    }

    public void filterResults(ArrayList orderSerialArr,
                              ArrayList orderedProductArr,
                              ArrayList orderDateArr,
                              ArrayList originArr,
                              ArrayList destArr,
                              ArrayList statusArr){
        this.orderSerialArr = orderSerialArr;
        this.orderedProductArr = orderedProductArr;
        this.orderDateArr = orderDateArr;
        this.originArr = originArr;
        this.destArr = destArr;
        this.statusArr = statusArr;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.MyViewHolder holder, int position) {
        holder.orderSerialTxt.setText(String.valueOf(orderSerialArr.get(position)));
        holder.orderedProductTxt.setText(String.valueOf(orderedProductArr.get(position)));
        holder.orderDateTxt.setText(String.valueOf(orderDateArr.get(position)));
        holder.originTxt.setText(String.valueOf(originArr.get(position)));
        holder.destTxt.setText(String.valueOf(destArr.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditOrder.class);
                intent.putExtra("Serial", String.valueOf(orderSerialArr.get(position)));
                intent.putExtra("Product", String.valueOf(orderedProductArr.get(position)));
                intent.putExtra("Date", String.valueOf(orderDateArr.get(position)));
                intent.putExtra("Origin", String.valueOf(originArr.get(position)));
                intent.putExtra("Destination", String.valueOf(destArr.get(position)));
                intent.putExtra("Status", String.valueOf(statusArr.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderSerialArr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView  orderSerialTxt, orderedProductTxt, orderDateTxt, originTxt, destTxt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            orderSerialTxt = itemView.findViewById(R.id.orderSerialNumberCard);
            orderedProductTxt = itemView.findViewById(R.id.ProductNameCard);
            orderDateTxt = itemView.findViewById(R.id.OrderDateCard);
            originTxt = itemView.findViewById(R.id.originCountryCard);
            destTxt = itemView.findViewById(R.id.destinationCountryCard);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
