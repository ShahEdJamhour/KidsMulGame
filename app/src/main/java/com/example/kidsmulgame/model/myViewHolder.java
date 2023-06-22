package com.example.kidsmulgame.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidsmulgame.R;

public class myViewHolder extends RecyclerView.ViewHolder {
  public ImageView imageView;
    public TextView name;
    public TextView area;
public TextView Circumference;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.imageView);
        name = itemView.findViewById(R.id.name);
       area = itemView.findViewById(R.id.area);
        Circumference= itemView.findViewById(R.id.Circumference);

    }
}
