package com.example.android.musicplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Find the View that shows the Home button
        Button home = (Button) findViewById(R.id.home_button);

        // Set a click listener on that View
        home.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the home button is clicked.
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }
}
