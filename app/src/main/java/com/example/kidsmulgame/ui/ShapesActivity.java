package com.example.kidsmulgame.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kidsmulgame.Adapters.MyAdapter;
import com.example.kidsmulgame.R;
import com.example.kidsmulgame.model.Shape;
import java.util.ArrayList;
import java.util.List;


public class ShapesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapes_activity);
        RecyclerView recyclerView= findViewById(R.id.recyclerview);

        List< Shape> items = new ArrayList<Shape>();
        items.add(new Shape("Square","side² square units"," 4 x side ",R.drawable.square));
        items.add(new Shape("Rectangle","A = b h , where is the base (width) and is the height (length)"," 2 b + 2 h",R.drawable.rectangle));
        items.add(new Shape("Circle ","A = pi r^2"," 2πr",R.drawable.circle));
        items.add(new Shape("Triangle","The sum of its sides: a + b + c.","  circumference of a triangle = a + b + c ",R.drawable.triangle));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }
}
