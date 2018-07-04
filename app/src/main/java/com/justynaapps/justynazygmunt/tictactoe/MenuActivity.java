package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MenuActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        intent = new Intent(MenuActivity.this, MainActivity.class);
        toggleStartGameButton(false);
    }

    private void toggleStartGameButton(boolean bool) {
        Button startTheGameButton = findViewById(R.id.startTheGameButton);
        startTheGameButton.setEnabled(bool);
    }

    public void gameModeOptionClick(View view) {
        toggleStartGameButton(true);
        RadioGroup gameModeRadioGroup = (RadioGroup) findViewById(R.id.gameModeRadioGroup);
        int gameMode = gameModeRadioGroup.getCheckedRadioButtonId();
        intent.putExtra("GameModeIndicator", gameMode);
    }

    public void playGameButtonClicked(View view) {
        startActivity(intent);
    }
}
