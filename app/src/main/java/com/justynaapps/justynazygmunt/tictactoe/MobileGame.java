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
        renderer.renderBoard(getBoard());
        renderer.informOfMove(Integer.toString(position), this.getPassivePlayer().getSign());
        renderer.removeListenerForID(position);
    }

    public void afterClick() {
        if (this.getActivePlayer() instanceof ComputerPlayer && !this.getBoard().isWon() && !this.getBoard().isTie()) {
            int computerPosition = getActivePlayer().pickPosition(this.getBoard());
            playMove(computerPosition);
        }
    }
}
