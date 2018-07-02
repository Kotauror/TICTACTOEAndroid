package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;
import com.core.tictactoe.Game;
import com.core.tictactoe.Player;

public class MobileGame extends Game {

    private Renderer renderer;

    public MobileGame(Board board, Player playerOne, Player playerTwo, Renderer renderer) {
        super(board, playerOne, playerTwo);
        this.renderer = renderer;
    }

    public void playMove(int position) {
        this.putSingOnBoard(position);
        this.switchPlayers();
    }

    public void afterClick() {
        if (this.getActivePlayer() instanceof ComputerPlayer && !this.getBoard().isWon() && !this.getBoard().isTie()) {
            System.out.println("m in computer stuff");
            int computerPosition = getActivePlayer().pickPosition(this.getBoard());
            this.getBoard().putSignOnBoard(this.getActivePlayer().getSign(), computerPosition);
            switchPlayers();
        }
//        renderer.renderBoard();
    }

}
