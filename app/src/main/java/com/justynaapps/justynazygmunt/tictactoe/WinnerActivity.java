package com.justynaapps.justynazygmunt.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void moveToNextPagePage(View view) {
        Intent jumpPage = new Intent(WinnerActivity.this, WelcomeActivity.class);
        startActivity(jumpPage);
    }
}
