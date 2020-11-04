package com.example.ontapgiuakyandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Products> products;
    private  ClickItemInterface clickItemInterface;

    public ListProductAdapter(Context context, ArrayList<Products> products,ClickItemInterface clickItemInterface) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.products = products;
        this.clickItemInterface = clickItemInterface;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_pro,parent,false);
        return new ProductViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Products pro = products.get(position);
        holder.tvName.setText(pro.getName());
        holder.tvPrice.setText(String.valueOf(pro.getGia())+"$");
        holder.imgView.setImageResource(pro.getHinh());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickItemInterface.onCLickItemTable(products.get(position));
//                Intent intent = new Intent(context, ProductDetailsActivity.class);
//                intent.putExtra("product", (Serializable) products.get(position));
//                intent.hasExtra("listOrder");
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvPrice;
        ImageView imgView;
        ListProductAdapter listProductAdapter;
        public ProductViewHolder(@NonNull View itemView,ListProductAdapter adapter) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txtName);
            tvPrice = itemView.findViewById(R.id.txtPrice);
            imgView = itemView.findViewById(R.id.img);
            this.listProductAdapter = adapter;
        }

    }
}
