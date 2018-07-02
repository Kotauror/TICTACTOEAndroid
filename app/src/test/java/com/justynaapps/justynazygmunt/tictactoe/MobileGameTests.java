package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileGameTests {

    private Board board;
    private MobilePlayer playerOne;
    private MobilePlayer playerTwo;
    private MobileGame mobileGame;

    @BeforeEach
    void instantiate() {
        board = new Board(3);
        playerOne = new MobilePlayer("X");
        playerTwo = new MobilePlayer("O");
        mobileGame = new MobileGame(board, playerOne, playerTwo);
    }

    @Test
    public void afterMovePutsSignOnBoardAndChangesActivePlayer() {
        mobileGame.playMove(2);

        assertEquals("X", mobileGame.getBoard().valueAtIndex(1));
        assertEquals("O", mobileGame.getActivePlayer().getSign());
    }
}
