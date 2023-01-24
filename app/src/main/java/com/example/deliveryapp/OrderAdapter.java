package com.example.deliveryapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        // for now these are public, will be fixed
        public LinearLayout containerView;
        public TextView textView;

        OrderViewHolder(View view){
            super(view);
            containerView = view.findViewById(R.id.list_ordered_item);
            textView = view.findViewById(R.id.list_ordered_item_text_view);

            containerView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Order current = (Order)containerView.getTag();
                    Intent intent = new Intent(view.getContext(), OrderScreen.class);
                    intent.putExtra("name",current.getProduct());
                    intent.putExtra("number",current.getSerial_number());

                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    // right now its hard coded will be fixed
    private List<Order> orders = Arrays.asList(
            new Order(1, "Product", "01-01-2023",
                    "USA","Israel"),
            new Order(2, "Product", "01-01-2023",
                    "UK","Israel")
    );

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_ordered_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order current = orders.get(position);
        holder.textView.setText(current.getProduct());
        holder.containerView.setTag(current);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }
}
