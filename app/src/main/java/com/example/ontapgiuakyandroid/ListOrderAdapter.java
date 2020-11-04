package com.example.ontapgiuakyandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListOrderAdapter extends RecyclerView.Adapter<ListOrderAdapter.OrderViewHolder> {

    Context context;
    ArrayList<Products> listOrders;
    LayoutInflater layoutInflater;

    public ListOrderAdapter(Context context, ArrayList<Products> listOrders) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listOrders = listOrders;
    }

    @NonNull
    @Override
    public ListOrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_order,parent,false);
        return new OrderViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ListOrderAdapter.OrderViewHolder holder, int position) {
        Products orders = listOrders.get(position);
        holder.txtName.setText(orders.getName());
        holder.txtPrice.setText(String.valueOf(orders.getGia()));
        holder.img.setImageResource(orders.getHinh());
    }

    @Override
    public int getItemCount() {
        return listOrders.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice, txtContent;
        ImageView img;
        ListOrderAdapter listOrderAdapter;

        public OrderViewHolder(@NonNull View itemView, ListOrderAdapter adapter) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtContent = itemView.findViewById(R.id.txtContent);
            img = itemView.findViewById(R.id.img);
            this.listOrderAdapter = adapter;
        }
    }
}
