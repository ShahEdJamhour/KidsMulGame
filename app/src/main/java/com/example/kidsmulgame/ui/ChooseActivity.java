package com.example.kidsmulgame.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.kidsmulgame.R;
import com.example.kidsmulgame.model.UserSettings;

public class ChooseActivity extends AppCompatActivity {
    private TextView textView2;
    private TextView textView3;
    private TextView textView5;
    private ImageView imageView;
    private ImageView imageView2;
    private Switch switch1;
    private UserSettings settings;
    private View parentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose);
        settings=(UserSettings)  getApplication();
        extracted();
        loadsharedPrefrences();
        initSwitchistener();

    }

    private void loadsharedPrefrences() {
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE);
        String theme = sharedPreferences.getString(UserSettings.CUSTOM_THEME, UserSettings.LIGHT_THEME);
        settings.setCustomTheme(theme);
        updateView();
    }


    private void initSwitchistener() {
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked)
                    settings.setCustomTheme(UserSettings.DARK_THEME);
                else
                    settings.setCustomTheme(UserSettings.LIGHT_THEME);

                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES, MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_THEME, settings.getCustomTheme());
                editor.apply();
                updateView();
            }
        });
    }

    private void updateView()
    {
        final int black = ContextCompat.getColor(this, R.color.black);
        final int white = ContextCompat.getColor(this, R.color.white);

        if(settings.getCustomTheme().equals(UserSettings.DARK_THEME))
        {

            parentView.setBackgroundColor(black);
            switch1.setChecked(true);
        }
        else
        {

            parentView.setBackgroundColor(white);
            switch1.setChecked(false);
        }

    }


    private void extracted() {
        textView2 = findViewById(R.id.textView2);
      //  textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        switch1= findViewById(R.id.switch1);
        parentView = findViewById(R.id.parentView);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseActivity.this, MultiplyActivity.class);
                startActivity(intent);
                finish();


            }
        }

        );
  /////////////////////////////////////////////////////////////
        imageView2.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             Intent intent = new Intent(ChooseActivity.this, ShapesActivity.class);
                                             startActivity(intent);
                                             finish();


                                         }
                                     });
  /////////////////////////////////////////////////////////////







    }


}
