package com.rksingh.myapplication.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rksingh.myapplication.DetailActivity;
import com.rksingh.myapplication.R;
import com.rksingh.myapplication.models.ModelsClass;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ItemViewHolder> {

    ArrayList<ModelsClass> list;
    Context context;

    public CustomAdapter(ArrayList<ModelsClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ModelsClass model = list.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.textView.setText(model.getItemName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(context, DetailActivity.class);
                intent.putExtra("image",model.getImage());
                intent.putExtra("price",model.getPrice());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("name",model.getItemName());
                intent.putExtra("type",1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, price, description;
        CardView cardParent;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.item_image_iv);
            textView = itemView.findViewById(R.id.item_name_tv);
            price = itemView.findViewById(R.id.orderPrice);
            description = itemView.findViewById(R.id.description);
            cardParent = itemView.findViewById(R.id.parent);

        }
    }

}
