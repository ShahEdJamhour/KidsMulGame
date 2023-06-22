package com.example.kidsmulgame.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kidsmulgame.Adapters.MyAdapter;
import com.example.kidsmulgame.R;
import com.example.kidsmulgame.model.Shape;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class ShapesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shapes_activity);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        RecyclerView recyclerView= findViewById(R.id.recyclerview);

        Button button ;

       button= findViewById(R.id.button2);

        List< Shape> items = new ArrayList<Shape>();
        items.add(new Shape("Square","Area=side²","    C=4xside ",R.drawable.square));
        items.add(new Shape("Rectangle","A = b h","  C=2 b + 2 h",R.drawable.rectangle));
        items.add(new Shape("Circle ","A = pir^2","   C=2πr",R.drawable.circle));
        items.add(new Shape("Triangle","A = ½ (b×h)","    C= a+b +c ",R.drawable.triangle));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));
        recyclerView.setVerticalScrollBarEnabled(true);
        Gson gson = new Gson();
        String itemsJson = gson.toJson(items);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("items", itemsJson);
        editor.apply();
        String storedItemsJson = sharedPreferences.getString("items", "");
        List<Shape> storedItems = gson.fromJson(storedItemsJson, new TypeToken<List<Shape>>() {}.getType());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShapesActivity.this, ChooseActivity.class);
                startActivity(intent);
                finish();


            }
        });

    }
}
