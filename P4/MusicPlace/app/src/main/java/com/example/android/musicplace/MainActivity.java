package com.example.android.musicplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the my music menu
        TextView myMusic = (TextView) findViewById(R.id.mymusic);

        // Set a click listener on that View
        myMusic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the my music View is clicked on.
            @Override
            public void onClick(View view) {
                Intent myMusicIntent = new Intent(MainActivity.this, MyMusicActivity.class);
                startActivity(myMusicIntent);
            }
        });

        // Find the View that shows the buy music menu
        TextView buyMusic = (TextView) findViewById(R.id.buymusic);

        // Set a click listener on that View
        buyMusic.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the buy music View is clicked on.
            @Override
            public void onClick(View view) {
                Intent buyMusicIntent = new Intent(MainActivity.this, BuyMusicActivity.class);
                startActivity(buyMusicIntent);
            }
        });

        // Find the View that shows the now playing menu
        TextView nowPlaying = (TextView) findViewById(R.id.nowplaying);

        // Set a click listener on that View
        nowPlaying.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the now playing View is clicked on.
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(nowPlayingIntent);
            }
        });

    }
}
