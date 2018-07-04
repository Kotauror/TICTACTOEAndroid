package com.justynaapps.justynazygmunt.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Bundle bundle = getIntent().getExtras();
        String winnerSign = bundle.getString("winnerSign");

        informOfWinner(winnerSign);
    }

    private void informOfWinner(String winnerSign) {
        int iDOfPlayerSignTextView = this.getResources().getIdentifier("playerSign", "id", this.getPackageName());
        TextView playerSignTextView = this.findViewById(iDOfPlayerSignTextView);
        playerSignTextView.setText(winnerSign);
    }
}
