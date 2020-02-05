package com.example.mystartuptest;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView helloWorldText;
    Button changeTextMainbtn;
    Button fuckingdonewiththis;
    Button nextButton;
    ImageView mainImage;
    int currentsong = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorldText = findViewById(R.id.mainText);
        changeTextMainbtn = findViewById(R.id.mainButton);
        fuckingdonewiththis = findViewById(R.id.stopButton);
        mainImage = findViewById(R.id.mainImage);
        nextButton = findViewById(R.id.nextButton);



        helloWorldText.setText("FUCK");

        String pictureUrl = "https://i.kym-cdn.com/photos/images/original/001/400/967/d04.jpg";

        Picasso.get().load(pictureUrl).into(mainImage);


        final MediaPlayer[] list = new MediaPlayer[3];
        list[0] = MediaPlayer.create(this,R.raw.sample);
        list[1] = MediaPlayer.create(this,R.raw.sample2);
        list[2] = MediaPlayer.create(this,R.raw.sample3);


        fuckingdonewiththis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloWorldText.setText("Coolsville");

                list[currentsong].pause();
                list[currentsong].seekTo(0);




            }
        });

        changeTextMainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloWorldText.setText("Stranger Danger");
                String url ="https://api.chucknorris.io/jokes/random";
                MyApiCall myApiCall = new MyApiCall();
                myApiCall.makeChuckNorrisJokeCall(helloWorldText,url,getApplicationContext());

                list[currentsong].start();


            }


        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list[currentsong].isPlaying()) {
                    list[currentsong].pause();
                    list[currentsong].seekTo(0);
                }
                currentsong++;
                if (currentsong == 2)
                    currentsong = 0;
            }
        });

            }

    }

