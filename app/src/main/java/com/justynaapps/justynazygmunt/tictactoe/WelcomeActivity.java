package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button enterTTTButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        enterTTTButton = (Button) findViewById(R.id.enterTTTButton);
    }

    public void moveToNextPagePage(View view) {
        Intent jumpPage = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(jumpPage);
    }
}
