package com.example.ontapgiuakyandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickItemInterface {

    RecyclerView rcvMain;
    ArrayList<Products> listPros;
    ArrayList<Products> listOrder;
    ListProductAdapter listProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent.hasExtra("listOrder")){
            Bundle bundle = intent.getExtras();
            listOrder = (ArrayList<Products>) bundle.getSerializable("listOrder");
        }

        listPros = new ArrayList<>();
        rcvMain = findViewById(R.id.rcvMain);
        listPros.add(new Products("P01", "mai", 100, 10, R.drawable.girl01));

        listPros.add(new Products("P01", "phượng", 200, 10, R.drawable.girl01));

        listPros.add(new Products("P01", "huyền", 300, 10, R.drawable.girl01));

        listPros.add(new Products("P01", "tâm", 400, 10, R.drawable.girl01));

        listPros.add(new Products("P01", "bitch", 500, 10, R.drawable.girl01));
        listProductAdapter = new ListProductAdapter(this,listPros,this);
        rcvMain.setAdapter(listProductAdapter);
        rcvMain.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void onCLickItemTable(Products products) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("product", products);
        intent.putExtra("listOrder", listOrder);
        startActivity(intent);
    }
}