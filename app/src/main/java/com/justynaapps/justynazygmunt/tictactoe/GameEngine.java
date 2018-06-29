package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.Game;
import com.core.tictactoe.Player;

public class GameEngine extends Game {
    private Board board;
    private Player active;
    private Player passive;

    public GameEngine(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.active = playerOne;
        this.passive = playerTwo;
    }

    public Board getBoard() {
        return this.board;
    }

    public Player getActivePlayer() {
        return this.active;
    }

    public Player getPassivePlayer() {
        return this.passive;
    }

    public void playMove(int position) {
        this.board.putSignOnBoard(this.active.getSign(), position);
        this.switchPlayers();
    }

    public void switchPlayers() {
        Player playerTemp = this.active;
        this.active = this.passive;
        this.passive = playerTemp;
    }
}
