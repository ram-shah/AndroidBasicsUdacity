package com.example.android.musicplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MyMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_music);

        // Find the View that shows the Now Playing button
        Button nowPlaying = (Button) findViewById(R.id.now_playing_button);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the now playing button is clicked.
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MyMusicActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

        // Find the View that shows the Home button
        Button home = (Button) findViewById(R.id.home_button);

        // Set a click listener on that View
        home.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the home button is clicked.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(MyMusicActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        // Find the View that shows the Buy Music button
        Button buyMusic = (Button) findViewById(R.id.buy_music_button);

        // Set a click listener on that View
        buyMusic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the buy music button is clicked.
            @Override
            public void onClick(View view) {
                Intent buyMusicIntent = new Intent(MyMusicActivity.this, BuyMusicActivity.class);
                startActivity(buyMusicIntent);
            }
        });

    }
}
