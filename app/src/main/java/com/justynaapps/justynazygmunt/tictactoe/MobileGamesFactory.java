package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;

public class MobileGamesFactory {

    MobileGamesFactory() {}

    public MobileGame getGame(int gameModeOption, Renderer renderer) {
        if (gameModeOption == 2131165256) {
            return new MobileGame(new Board(3), new MobilePlayer("X"), new MobilePlayer("O"), renderer);
        } else {
            return new MobileGame(new Board(3), new MobilePlayer("X"), new ComputerPlayer("O"), renderer);
        }
    }
}
