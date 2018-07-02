package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUi;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MobilePlayerTests {

    private CommandLineUi commandLineUi;
    private Board board;

    @BeforeEach
    void instantiate() {
        commandLineUi = new CommandLineUi(System.out, System.in);
        board = new Board(3);
    }

    @Test
    public void returnsZeroAsPickedPosition() {
        MobilePlayer mobilePlayer = new MobilePlayer("X");
        assertEquals(0, mobilePlayer.pickPosition(commandLineUi, board));
    }

    @Test
    public void returnsNullAsType() {
        MobilePlayer mobilePlayer = new MobilePlayer("X");
        assertEquals(null, mobilePlayer.getType());
    }
}