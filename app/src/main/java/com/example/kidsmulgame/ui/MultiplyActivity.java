package com.example.kidsmulgame.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kidsmulgame.R;
import com.example.kidsmulgame.model.Calculate;

import java.util.Timer;
import java.util.TimerTask;

public class MultiplyActivity extends AppCompatActivity {

    private TextView equation;
    private ImageView next_equ;
    private ImageView correct;
    private ImageView incorrect;
    private ProgressBar progressBar;
    private int counter = 0;
    private int status;
    private ImageView msg;
    private TextView msg2;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul);




        extracted();
        prog();
        displayEquation();
    }

    private void extracted() {
        equation = findViewById(R.id.tvEquation);
        next_equ = findViewById(R.id.nextEquation);
        correct = findViewById(R.id.correct);
        incorrect = findViewById(R.id.incorrect);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        msg2=findViewById(R.id.msg2);
        button= findViewById(R.id.button);


        next_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = 0;
                prog();
                displayEquation();

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MultiplyActivity.this, ChooseActivity.class);
                startActivity(intent);
                finish();


            }
        });
    }


    /**
     * Using another thread to consume the time for setting the progress bar
     */
    private void prog() {

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter == 130) {
                    t.cancel();

                }
            }
        };
    /*
    Using timer Schedule to achieve 30*100=3000ms->3s
     */
        t.schedule(tt, 0, 30);
    }

    private void displayEquation() {
        /**
         Prepare data
         */
        Calculate calc = new Calculate();
        calc.generateRandom();
        calc.calculateResult();
        status = calc.getResStatus();
        String equ = calc.getNum1() + " * " + calc.getNum2() + " = " + calc.getAns();
        equation.setText(equ);
        msg2.setText("");

        /**
         * Check the corectness of the equation
         */
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (status == 1) {
                    Toast.makeText(MultiplyActivity.this, "Yayy, correct answer", Toast.LENGTH_SHORT).show();



                } else {
                    Toast.makeText(MultiplyActivity.this, "Oops:( Incorrect answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /**
         * Check the incorectness of the equation
         */
        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (status == 0) {
                    Toast.makeText(MultiplyActivity.this, "Yayy! Correct answer", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultiplyActivity.this, "Oops :( Incorrect answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
        /**
         * This is an invidual timer uses after a progressbar filled to clean the textview
         */
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {

                equation.setText("oops u ran out of time");
                msg2.setText("Click on the arrow to try another one");
            }
        };

        timer.schedule(task, 3000);//execute after 10 seconds
    }



}