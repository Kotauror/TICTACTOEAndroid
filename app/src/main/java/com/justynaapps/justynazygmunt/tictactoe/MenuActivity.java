package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MenuActivity extends AppCompatActivity {

    private Intent intent;
    private PlayerTypes player1;
    private PlayerTypes player2;
    private boolean playerFirstSelectedFlag;
    private boolean playerSecondSelectedFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        intent = new Intent(MenuActivity.this, MainActivity.class);
        toggleStartGameButton();
    }

    private void toggleStartGameButton() {
        if (playerFirstSelectedFlag && playerSecondSelectedFlag) {
            Button startTheGameButton = findViewById(R.id.startTheGameButton);
            startTheGameButton.setEnabled(true);
        }
    }

    public void playerOneRGClicked(View view) {
        playerFirstSelectedFlag = true;
        toggleStartGameButton();
        RadioGroup playerOneRG = (RadioGroup) findViewById(R.id.playerOneRG);
        int playerOne = playerOneRG.getCheckedRadioButtonId();
        View radioButton = playerOneRG.findViewById(playerOne);
        int index = playerOneRG.indexOfChild(radioButton);
        if (index == 0) {
            player1 = PlayerTypes.HUMAN;
            View player2Computer = findViewById(R.id.playerTwoComputer);
            player2Computer.setVisibility(View.VISIBLE);
        } else {
            player1 = PlayerTypes.COMPUTER;
            View player2Computer = findViewById(R.id.playerTwoComputer);
            player2Computer.setVisibility(View.INVISIBLE);
        }
    }

    public void playerTwoRGClicked(View view) {
        playerSecondSelectedFlag = true;
        toggleStartGameButton();
        RadioGroup playerTwoRG = (RadioGroup) findViewById(R.id.playerTwoRG);
        int playerTwo = playerTwoRG.getCheckedRadioButtonId();
        View radioButton = playerTwoRG.findViewById(playerTwo);
        int index = playerTwoRG.indexOfChild(radioButton);
        if (index == 0) {
            player2 = PlayerTypes.HUMAN;
            View player1Computer = findViewById(R.id.playerOneComputer);
            player1Computer.setVisibility(View.VISIBLE);
        } else {
            player2 = PlayerTypes.COMPUTER;
            View player1Computer = findViewById(R.id.playerOneComputer);
            player1Computer.setVisibility(View.INVISIBLE);
        }
    }

    public void playGameButtonClicked(View view) {
        String gameMode = player1.value() + player2.value();
        intent.putExtra("GameModeIndicator", gameMode);
        startActivity(intent);
    }
}
