package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tie);
    }

    public void moveToNextPagePage(View view) {
        Intent intent = new Intent(TieActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }
}
