package com.example.ontapgiuakyandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {
    //meta data
    ImageView imgView;

    TextView tvName, tvPrice;
    TextView tvNumber;

    Button btnThanhToan;

    Products product;
    Intent intent;
    Bundle bundle;
    //remember array in order
    ArrayList<Products> listOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvName = findViewById(R.id.txtName);
        tvPrice = findViewById(R.id.txtPrice);
        imgView = findViewById(R.id.img);
        tvNumber = findViewById(R.id.txtNumber);
        btnThanhToan = findViewById(R.id.btnThanhToan);

        intent = getIntent();
        bundle = intent.getExtras();
        product = (Products) bundle.getSerializable("product");

        tvName.setText(product.getName());
        tvPrice.setText(String.valueOf(product.getGia()) + " $");
        imgView.setImageResource(product.getHinh());

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(intent.hasExtra("listOrder")){
                    listOrder= (ArrayList<Products>) bundle.getSerializable("listOrder");
                    if(listOrder == null){
                        listOrder = new ArrayList<>();
                    }else {
                        listOrder = (ArrayList<Products>) bundle.getSerializable("listOrder");
                    }
                    Toast.makeText(ProductDetailsActivity.this,"This"+listOrder,Toast.LENGTH_SHORT).show();
                }
                listOrder.add(product);
                Intent intent1 = new Intent(ProductDetailsActivity.this,OrderActivity.class);
                intent1.putExtra("listOrder", listOrder);
                startActivity(intent1);
            }
        });

    }
}