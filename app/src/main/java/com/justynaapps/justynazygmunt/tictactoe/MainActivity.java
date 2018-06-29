package com.justynaapps.justynazygmunt.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.core.tictactoe.Board;

public class MainActivity extends AppCompatActivity {

    private GameEngine gameEngine;


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
        MobilePlayer player2 = new MobilePlayer("O");
        this.gameEngine = new GameEngine(board, player1, player2);
    }

    private void createMoveListenersForFieldsOnGrid() {
        for (int cellNumber = 1; cellNumber < gameEngine.getBoard().getPlaces().length +1; cellNumber++ ){
            final TextView singleGrid = getTextViewForId(cellNumber);
            MoveListener moveListener = new MoveListener(getApplicationContext(), singleGrid, cellNumber, gameEngine);
            singleGrid.setOnClickListener(moveListener);
        }
    }

    private TextView getTextViewForId(int i) {
        int idOfWindowInMobileGrid = getResources().getIdentifier("place_number_" + i, "id", getPackageName());
        return findViewById(idOfWindowInMobileGrid);
    }

    private void renderBoard() {
        for (int i = 1; i < gameEngine.getBoard().getPlaces().length +1 ; i++) {
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setText(gameEngine.getBoard().valueAtIndex(i-1));
        }
    }
}
