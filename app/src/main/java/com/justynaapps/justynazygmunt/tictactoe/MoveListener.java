package com.justynaapps.justynazygmunt.tictactoe;

import android.view.View;
import android.widget.TextView;

public class MoveListener implements View.OnClickListener {

    private TextView singleGrid;
    private int cellNumber;
    private GameEngine gameEngine;

    public MoveListener(TextView singleGrid, int cellNumber, GameEngine gameEngine) {
        this.singleGrid = singleGrid;
        this.cellNumber = cellNumber;
        this.gameEngine = gameEngine;
    }

    @Override
    public void onClick(View view) {
        if (this.gameEngine.getBoard().isNonTaken(Integer.toString(cellNumber)) && !this.gameEngine.getBoard().isWon()) {
            int numberPickedByUser = Integer.parseInt(this.singleGrid.getText().toString());
            this.gameEngine.playMove(numberPickedByUser);
            updateView(numberPickedByUser);
        }
    }

    private void updateView(int numberPickedByUser) {
        this.singleGrid.setText(this.gameEngine.getBoard().valueAtIndex(numberPickedByUser-1));
    }
}
