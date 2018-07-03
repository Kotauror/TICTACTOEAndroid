package com.justynaapps.justynazygmunt.tictactoe;

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
        this.mobileGame = new MobileGame(board, player1, computerPlayer, renderer);

        renderer.renderBoard(board);
    }

    public void handleSpaceOnClick(View view) {
        String numberPickedByUser = ((TextView)view).getText().toString();
        if (this.mobileGame.getBoard().isNonTaken(numberPickedByUser) && !this.mobileGame.getBoard().isWon()) {
            this.mobileGame.playMove(Integer.parseInt(numberPickedByUser));
            renderer.removeListenerForID(Integer.parseInt(numberPickedByUser));
            mobileGame.afterClick();
        }
    }
}
