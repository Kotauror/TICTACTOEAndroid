package com.justynaapps.justynazygmunt.tictactoe;

import android.widget.TextView;

import com.core.tictactoe.Board;

public class Renderer {

    private MainActivity activity;

    Renderer(MainActivity mainActivity) {
        this.activity = mainActivity;
    }

    public void renderBoard(Board board) {
        for (int i = 1; i < board.getPlaces().length +1 ; i++) {
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setText(board.valueAtIndex(i-1));
        }
    }

    protected TextView getTextViewForId(int i) {
        int idOfWindowInMobileGrid = this.activity.getResources().getIdentifier("place_number_" + i, "id", this.activity.getPackageName());
        return this.activity.findViewById(idOfWindowInMobileGrid);
    }

    protected void removeListenerForID(int PositionID) {
        TextView textView = getTextViewForId(PositionID);
        textView.setOnClickListener(null);
    }
}