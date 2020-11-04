package com.example.ontapgiuakyandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    RecyclerView rcvPay;
    ListOrderAdapter listOrderAdapter;
    ArrayList<Products> listProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        rcvPay = findViewById(R.id.rcvPay);
        listProduct = new ArrayList<>();

        listProduct = (ArrayList<Products>) bundle.getSerializable("listOrder");
//        Toast.makeText(this,"This"+listProduct,Toast.LENGTH_SHORT).show();
        listOrderAdapter = new ListOrderAdapter(this,listProduct);
        rcvPay.setAdapter(listOrderAdapter);
        rcvPay.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.btnContinutes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(OrderActivity.this,MainActivity.class);
                intent1.putExtra("listOrder", listProduct);
                startActivity(intent1);
            }
        });

    }
}