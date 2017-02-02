package com.introtoandriod.button_counter_keane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1; // -
    private Button button2; // +
    private Button button3; // reset
    private TextView view;  // #
    private ImageView image;
    private int clicks;
    private int maxClicks = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        view = (TextView) findViewById(R.id.view);
        image = (ImageView) findViewById(R.id.image);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Long mess that converts char sequence to string to int
                int count = Integer.parseInt(String.valueOf(view.getText()));
                int newCount = count--;

                view.setText(String.valueOf(newCount));

                clicks++;
                if(clicks == maxClicks){
                    surprise();
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Long mess that converts char sequence to string to int
                int count = Integer.parseInt(String.valueOf(view.getText()));
                int newCount = count++;

                view.setText(newCount);

                clicks++;
                if(clicks == maxClicks){
                    surprise();
                }
            }
        });

        button3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v){
                view.setText("0");
                clicks++;
                if(clicks == maxClicks){
                    surprise();
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState( Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putCharSequence("count",view.getText());
    }

    @Override
    public void onRestoreInstanceState( Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        view.setText(savedInstanceState.getCharSequence("count"));
    }

    private void surprise(){
         image.setVisibility(View.VISIBLE);
    }
}
