package com.rksingh.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;

import com.rksingh.myapplication.Adapters.CustomAdapter;
import com.rksingh.myapplication.models.ModelsClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ArrayList<ModelsClass> list = new ArrayList<>();

        list.add(new ModelsClass(R.drawable.br1,"Burger", "5","Chicken Burger with Extra cheese"));
        list.add(new ModelsClass(R.drawable.br2,"Burger","0","The offer to download the coupons end Thursday May 28"));
        list.add(new ModelsClass(R.drawable.br3,"Burger","10","Meaty portobello mushrooms make for the perfect vegetarian burger"));
        list.add(new ModelsClass(R.drawable.br4,"Burger","4","Burger O'Clock is available to satiate your hunger"));
        list.add(new ModelsClass(R.drawable.br5,"Burger","5","Chicken Burger with Extra cheese"));
        list.add(new ModelsClass(R.drawable.br6,"Burger","8","Chicken Burger"));
        list.add(new ModelsClass(R.drawable.br3,"Burger","10","Chicken Burger with Extra cheese"));
        list.add(new ModelsClass(R.drawable.br4,"Burger","4","Chicken Burger with Extra cheese"));
        list.add(new ModelsClass(R.drawable.br4,"Burger","6","Meaty portobello mushrooms make for the perfect vegetarian burger"));
        list.add(new ModelsClass(R.drawable.br6,"Burger","3","Burger O'Clock is available to satiate your hunger"));

        adapter   = new CustomAdapter(list, MainActivity.this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}