package com.justynaapps.justynazygmunt.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;

public class MainActivity extends AppCompatActivity {

    private MobileGame mobileGame;
    private ComputerPlayer computerPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGame();
        renderBoard();
    }

    private void createGame() {
        Board board = new Board(3);
        MobilePlayer player1 = new MobilePlayer("X");
        MobilePlayer player2 = new MobilePlayer("O");
        Renderer renderer = new Renderer();
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        this.mobileGame = new MobileGame(board, player1, computerPlayer, renderer);
    }

    protected MobileGame getMobileGame() {
        return mobileGame;
    }

    protected TextView getTextViewForId(int i) {
        int idOfWindowInMobileGrid = getResources().getIdentifier("place_number_" + i, "id", getPackageName());
        return findViewById(idOfWindowInMobileGrid);
    }

    protected void renderBoard() {
        for (int i = 1; i < getMobileGame().getBoard().getPlaces().length +1 ; i++) {
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setText(getMobileGame().getBoard().valueAtIndex(i-1));
        }
    }

    public void handleSpace(View view) {
        String cellPickedByUser = ((TextView)view).getText().toString();
        if (this.mobileGame.getBoard().isNonTaken(cellPickedByUser) && !this.mobileGame.getBoard().isWon()) {
            this.mobileGame.playMove(Integer.parseInt(cellPickedByUser));
//            renderBoard();
            updateView(view, Integer.parseInt(cellPickedByUser));
            mobileGame.afterClick();
        }
    }

    private void updateView(View view, int numberPickedByUser) {
        ((TextView)view).setText(this.mobileGame.getBoard().valueAtIndex(numberPickedByUser-1));
        view.setOnClickListener(null);
    }
}
