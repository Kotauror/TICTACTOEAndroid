package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class MoveListener implements View.OnClickListener {

    private TextView singleGrid;
    private int cellNumber;
    private MobileGame mobileGame;
    private Context context;

    public MoveListener(Context context, TextView singleGrid, int cellNumber, MobileGame mobileGame) {
        this.context = context;
        this.singleGrid = singleGrid;
        this.cellNumber = cellNumber;
        this.mobileGame = mobileGame;
    }

    @Override
    public void onClick(View view) {
        if (this.mobileGame.getBoard().isNonTaken(Integer.toString(cellNumber)) && !this.mobileGame.getBoard().isWon()) {
            int numberPickedByUser = Integer.parseInt(this.singleGrid.getText().toString());
            this.mobileGame.playMove(numberPickedByUser);
            updateView(numberPickedByUser);
            mobileGame.afterClick();
            // 2. Messanger.InformOfMove(numberPickedByUser, mobileGame.getPassivePlayer().getSign();)

            // showToast(numberPickedByUser);
        }
    }

    private void updateView(int numberPickedByUser) {
        this.singleGrid.setText(this.mobileGame.getBoard().valueAtIndex(numberPickedByUser-1));
    }

//    private void showToast(int numberPickedByUser) {
//        String sign = mobileGame.getPassivePlayer().getSign();
//        Toast.makeText(context, "Player " + sign + " picked " + numberPickedByUser, Toast.LENGTH_LONG).show();
//    }
}
