package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MobileGame mobileGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Renderer renderer = new Renderer(this);
        MobileGamesFactory mobileGamesFactory = new MobileGamesFactory(renderer);
        Bundle bundle = getIntent().getExtras();
        MobileGameMode gameMode = (MobileGameMode) bundle.getSerializable("GameModeIndicator");
        System.out.println("IN MAIN ACTIVITT INT: " + gameMode);

        this.mobileGame = mobileGamesFactory.getGame(gameMode);
        renderer.renderBoard(mobileGame.getBoard());

        handleFirstComputerMove();
    }


    private void handleFirstComputerMove() {
        if (mobileGame.getActivePlayer().getType().equals("Computer")) {
            mobileGame.handleComputerMove();
        }
    }

    public void handleSpaceOnClick(View view) {
        String numberPickedByUser = ((TextView)view).getText().toString();
        if (this.mobileGame.getBoard().isNonTaken(numberPickedByUser) && !this.mobileGame.getBoard().isWon()) {
            this.mobileGame.playMove(Integer.parseInt(numberPickedByUser));
            mobileGame.afterClick();
            afterGame();
        }
    }

    private void afterGame() {
        if (mobileGame.getBoard().isWon()) {
            startWonGameActivity();
        }
        if (mobileGame.getBoard().isTie()) {
            startTieGameActivity();
        }
    }

    private void startWonGameActivity() {
        Intent intent = new Intent(MainActivity.this, WinnerActivity.class);
        Bundle bundleWithWinnerSign = new Bundle();
        bundleWithWinnerSign.putString("winnerSign", mobileGame.getBoard().winnerSign());
        intent.putExtras(bundleWithWinnerSign);
        startActivity(intent);
    }

    private void startTieGameActivity() {
        Intent intent = new Intent(MainActivity.this, TieActivity.class);
        startActivity(intent);
    }
}
