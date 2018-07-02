package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.Game;
import com.core.tictactoe.Player;

public class MobileGame extends Game {

    public MobileGame(Board board, Player playerOne, Player playerTwo) {
        super(null, board, playerOne, playerTwo);
    }

    public void playMove(int position) {
        this.getBoard().putSignOnBoard(this.getActivePlayer().getSign(), position);
        this.switchPlayers();
    }
}
