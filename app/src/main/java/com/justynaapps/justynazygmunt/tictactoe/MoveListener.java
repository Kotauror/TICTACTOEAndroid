package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MoveListener implements View.OnClickListener {

    private TextView singleGrid;
    private int cellNumber;
    private GameEngine gameEngine;
    private Context context;

    public MoveListener(Context context, TextView singleGrid, int cellNumber, GameEngine gameEngine) {
        this.context = context;
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
            showToast(numberPickedByUser);
            // Messanger.InformOfMove(numberPickedByUser, gameEngine.getPassivePlayer().getSign();)
        }
    }

    private void updateView(int numberPickedByUser) {
        this.singleGrid.setText(this.gameEngine.getBoard().valueAtIndex(numberPickedByUser-1));
    }

    private void showToast(int numberPickedByUser) {
        String sign = gameEngine.getPassivePlayer().getSign();
        Toast.makeText(context, "Player " + sign + " picked " + numberPickedByUser, Toast.LENGTH_LONG).show();
    }
}
