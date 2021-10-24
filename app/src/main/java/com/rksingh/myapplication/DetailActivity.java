package com.rksingh.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private ImageView itemImage, subImage, addImage;
    private TextView tvQuantity, tvPrice, tvName, tvDescription;
    private EditText etName, etPhone;
    private Button btnOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // find view ids
        initUi();

        final DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type", 0) == 1) {

            Intent intent = getIntent();
            final int image = intent.getIntExtra("image", 0);
            final int price = Integer.parseInt(intent.getStringExtra("price"));
            final String name = intent.getStringExtra("name");
            final String description = intent.getStringExtra("description");

            itemImage.setImageResource(image);
            tvPrice.setText(String.valueOf(price));
            tvName.setText(name);
            tvDescription.setText(description);


            btnOrder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean isInserted = helper.insertOrder(
                            etName.getText().toString(),
                            etPhone.getText().toString(),
                            price,
                            image,
                            description,
                            name,
                            Integer.parseInt(tvQuantity.getText().toString())
                    );

                    if (isInserted)
                        Toast.makeText(DetailActivity.this, "Data Success..!", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });

        } else {

        }
    }

    private void initUi() {

        itemImage = findViewById(R.id.detailImage);
        subImage = findViewById(R.id.subtract);
        addImage = findViewById(R.id.add);
        tvQuantity = findViewById(R.id.quantity);
        tvPrice = findViewById(R.id.itemPrice);
        etName = findViewById(R.id.nameBox);
        etPhone = findViewById(R.id.phoneBox);
        btnOrder = findViewById(R.id.insertButton);
        tvName = findViewById(R.id.itemName);
        tvDescription = findViewById(R.id.detailDescription);
    }
}