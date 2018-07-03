package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileGameTests {

    private Board board;
    private MobilePlayer playerOne;
    private MobilePlayer playerTwo;
    private MobileGame HvHmobileGame;
    private MobileGame HvCmobileGame;
    private ComputerPlayer computerPlayer;

    @BeforeEach
    void instantiate() {
        board = new Board(3);
        playerOne = new MobilePlayer("X");
        playerTwo = new MobilePlayer("O");
        computerPlayer = new ComputerPlayer("O");
        HvHmobileGame = new MobileGame(board, playerOne, playerTwo);
        HvCmobileGame = new MobileGame(board, playerOne, computerPlayer);
    }

    @Test
    public void afterMovePutsSignOnBoardAndChangesActivePlayer() {
        HvHmobileGame.playMove(2);

        assertEquals("X", HvHmobileGame.getBoard().valueAtIndex(1));
        assertEquals("O", HvHmobileGame.getActivePlayer().getSign());
    }

    @Test
    public void computerPlaysItsMove() {
        HvCmobileGame.playMove(2);
        HvCmobileGame.afterClick();

        assertEquals("O", HvHmobileGame.getBoard().valueAtIndex(0));
    }


}
