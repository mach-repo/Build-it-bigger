package com.example.android.androidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeTellingActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_telling);

        if(getIntent() != null){
            Intent intent = getIntent();

            if(intent.hasExtra(JOKE)){
                String passedJoke = intent.getStringExtra(JOKE);

                TextView jokeTextView = (TextView) findViewById(R.id.joke_textview);
                jokeTextView.setText(passedJoke);
            }
        }
    }
}
