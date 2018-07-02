package com.justynaapps.justynazygmunt.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        createMoveListenersForFieldsOnGrid();

        renderBoard();
    }

    private void createGame() {
        Board board = new Board(3);
        MobilePlayer player1 = new MobilePlayer("X");
//        MobilePlayer player2 = new MobilePlayer("O");
        Renderer renderer = new Renderer();
        ComputerPlayer computerPlayer = new ComputerPlayer("O");
        this.mobileGame = new MobileGame(board, player1, computerPlayer, renderer);
    }

    private void createMoveListenersForFieldsOnGrid() {
        for (int cellNumber = 1; cellNumber < mobileGame.getBoard().getPlaces().length +1; cellNumber++ ){
            final TextView singleGrid = getTextViewForId(cellNumber);
            MoveListener moveListener = new MoveListener(getApplicationContext(), singleGrid, cellNumber, mobileGame);
            singleGrid.setOnClickListener(moveListener);
        }
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
}
