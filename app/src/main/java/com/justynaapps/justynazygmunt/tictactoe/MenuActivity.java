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
        View radioButton = gameModeRadioGroup.findViewById(gameMode);
        int index = gameModeRadioGroup.indexOfChild(radioButton);
        RadioGroup whoGoesFirstRadioGroup = (RadioGroup) findViewById(R.id.whoGoesFirstRadioGroup);
        if (index == 0) {
            intent.putExtra("GameModeIndicator", MobileGameMode.HUMAN_VS_HUMAN);
            whoGoesFirstRadioGroup.setVisibility(View.INVISIBLE);
        } else {
            toggleStartGameButton(false);
            whoGoesFirstRadioGroup.setVisibility(View.VISIBLE);
        }
    }

    public void gameOrderClick(View view) {
        RadioGroup computerGameOrder = (RadioGroup) findViewById(R.id.whoGoesFirstRadioGroup);
        int gameMode = computerGameOrder.getCheckedRadioButtonId();
        View radioButton = computerGameOrder.findViewById(gameMode);
        int index = computerGameOrder.indexOfChild(radioButton);
        toggleStartGameButton(true);
        if (index == 0) {
            intent.putExtra("GameModeIndicator", MobileGameMode.HUMAN_VS_COMPUTER);
        } else {
            intent.putExtra("GameModeIndicator", MobileGameMode.COMPUTER_VS_HUMAN);
        }
    }

    public void playGameButtonClicked(View view) {
        startActivity(intent);
    }
}
