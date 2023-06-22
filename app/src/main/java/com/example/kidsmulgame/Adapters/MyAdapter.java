package com.example.kidsmulgame.Adapters;


import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidsmulgame.R;
import com.example.kidsmulgame.model.Shape;
import com.example.kidsmulgame.model.myViewHolder;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<myViewHolder> {
    Context context;
    List<Shape> items;

    public MyAdapter(Context context, List<Shape> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.area.setText(items.get(position).getArea());
        holder.Circumference.setText(items.get(position).getCircumference());
        holder.imageView.setImageResource(items.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

