package com.justynaapps.justynazygmunt.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.core.tictactoe.Board;

public class MainActivity extends AppCompatActivity {


    private Board board;
    private String currentSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        board = new Board(3);
        currentSign = "X";

        createOnClickListenersForFieldsOnGrid();
        renderGridWithNumbers();
    }


    private void createOnClickListenersForFieldsOnGrid() {
        for (int i = 1; i < board.getPlaces().length +1; i++ ){
            final TextView singleGrid = getTextViewForId(i);
            singleGrid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (singleGrid.getText() != "X" && singleGrid.getText() != "O" && !board.isWon()) {
                        int numberPickedByUser = Integer.parseInt(singleGrid.getText().toString());
                        board.putSignOnBoard(currentSign, numberPickedByUser);
                        refreshSingleGrid(currentSign, numberPickedByUser);
                        changeCurrentSign();
                    }
                }
            });
        }
    }

    private TextView getTextViewForId(int i) {
        int idOfWindowInMobileGrid = getResources().getIdentifier("place_number_" + i, "id", getPackageName());
        return findViewById(idOfWindowInMobileGrid);
    }

    private void renderGridWithNumbers() {
        for (int i = 1; i < board.getPlaces().length +1 ; i++) {
            final TextView placeOnMobileGrid = getTextViewForId(i);
            placeOnMobileGrid.setText(board.valueAtIndex(i-1));
        }
    }

    private void refreshSingleGrid(String currentSign, int position) {
        final TextView placeOnMobileGrid = getTextViewForId(position);
        placeOnMobileGrid.setText(currentSign);
    }

    private void changeCurrentSign() {
        if (currentSign.equals("X")) {
            currentSign = "O";
        } else {
            currentSign = "X";
        }
    }
}
