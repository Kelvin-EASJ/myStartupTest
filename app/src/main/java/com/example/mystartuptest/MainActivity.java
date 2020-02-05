package com.example.mystartuptest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView helloWorldText;
    Button changeTextMainbtn;
    Button fuckingdonewiththis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorldText = findViewById(R.id.mainText);
        changeTextMainbtn = findViewById(R.id.mainButton);
        fuckingdonewiththis = findViewById(R.id.stopButton);


        helloWorldText.setText("FUCK");

        final MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.sample);

        fuckingdonewiththis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloWorldText.setText("Coolsville");
                mediaPlayer.stop();
            }
        });

        changeTextMainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloWorldText.setText("Stranger Danger");
                mediaPlayer.start();


                    }
                });

        String url ="https://api.chucknorris.io/jokes/random";
        MyApiCall myApiCall = new MyApiCall();
        myApiCall.makeChuckNorrisJokeCall(helloWorldText,url,getApplicationContext());

            }

    }

