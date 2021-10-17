 package com.rksingh.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.rksingh.myapplication.Adapters.CustomAdapter;
import com.rksingh.myapplication.Adapters.OrdersAdapter;
import com.rksingh.myapplication.models.OrderModel;

import java.util.ArrayList;

 public class OrderActivity extends AppCompatActivity {

     RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView = findViewById(R.id.orderRecyclerView);


        DBHelper helper = new DBHelper(this);
        ArrayList<OrderModel> list  =  helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list, OrderActivity.this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}