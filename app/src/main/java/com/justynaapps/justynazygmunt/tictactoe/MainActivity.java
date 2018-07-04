package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;

public class MainActivity extends AppCompatActivity {

    private Renderer renderer;
    private MobileGame mobileGame;
    private MobilePlayer player1;
    private MobilePlayer player2;
    private ComputerPlayer computerPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        renderer = new Renderer(this);

        createGame();
    }

    private void createGame() {
        Board board = new Board(3);
        player1 = new MobilePlayer("X");
        player2 = new MobilePlayer("O");
        computerPlayer = new ComputerPlayer("O");
        this.mobileGame = new MobileGame(board, player1, player2, renderer);

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
            Intent jumpPage = new Intent(MainActivity.this, WinnerActivity.class);
            Bundle bundleWithWinnerSign = new Bundle();
            bundleWithWinnerSign.putString("winnerSign", mobileGame.getBoard().winnerSign());
            jumpPage.putExtras(bundleWithWinnerSign);
            startActivity(jumpPage);
        }
        if (mobileGame.getBoard().isTie()) {
            Intent jumpPage = new Intent(MainActivity.this, TieActivity.class);
            startActivity(jumpPage);
        }
    }
}
