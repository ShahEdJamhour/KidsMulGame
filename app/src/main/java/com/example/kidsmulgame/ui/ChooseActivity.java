package com.example.kidsmulgame.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kidsmulgame.R;

public class ChooseActivity extends AppCompatActivity {
    private TextView textView2;
    private TextView textView3;
    private TextView textView5;
    private ImageView imageView;
    private ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);

        extracted();
    }

    private void extracted() {
        textView2 = findViewById(R.id.textView2);
      //  textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MultiplyActivity.class);
                startActivity(intent);
                finish();


            }
        });


    }


}
