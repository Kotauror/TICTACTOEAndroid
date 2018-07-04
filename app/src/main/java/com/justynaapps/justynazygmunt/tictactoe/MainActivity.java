package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.core.tictactoe.Board;
import com.core.tictactoe.Player;

public class MainActivity extends AppCompatActivity {

    private Renderer renderer;
    private MobileGame mobileGame;
    private MobilePlayersFactory mobilePlayersFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renderer = new Renderer(this);
        mobilePlayersFactory = new MobilePlayersFactory();
        Bundle bundle = getIntent().getExtras();
        int gameMode = bundle.getInt("GameModeIndicator");

        createGame(gameMode);
    }

    private void createGame(int gameMode) {
        Board board = new Board(3);
        Player[] players = mobilePlayersFactory.getPlayers(gameMode);
        this.mobileGame = new MobileGame(board, players[0], players[1], renderer);

        renderer.renderBoard(board);
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
            Intent intent = new Intent(MainActivity.this, WinnerActivity.class);
            Bundle bundleWithWinnerSign = new Bundle();
            bundleWithWinnerSign.putString("winnerSign", mobileGame.getBoard().winnerSign());
            intent.putExtras(bundleWithWinnerSign);
            startActivity(intent);
        }
        if (mobileGame.getBoard().isTie()) {
            Intent intent = new Intent(MainActivity.this, TieActivity.class);
            startActivity(intent);
        }
    }
}
