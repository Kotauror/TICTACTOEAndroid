package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.ComputerPlayer;

import java.util.HashMap;
import java.util.Map;

public class MobileGamesFactory {

    private HashMap<MobileGameMode, MobileGame> mobileGamesOptions;
    private Renderer renderer;

    MobileGamesFactory(Renderer renderer) {
        this.renderer = renderer;
        this.mobileGamesOptions = new HashMap();
        this.createGameOptions();
    }

    public MobileGame getGame(MobileGameMode gameModeOption) {
        for(Map.Entry<MobileGameMode, MobileGame> mobileGame : this.mobileGamesOptions.entrySet()) {
            MobileGameMode gameMode = mobileGame.getKey();
            if (gameMode.value() == gameModeOption.value()) {
                return mobileGame.getValue();
            }
        }
        return null;
    }

    private void createGameOptions() {
        this.mobileGamesOptions.put(MobileGameMode.HUMAN_VS_HUMAN, new MobileGame(new Board(3), new MobilePlayer("X"), new MobilePlayer("O"), renderer));
        this.mobileGamesOptions.put(MobileGameMode.HUMAN_VS_COMPUTER, new MobileGame(new Board(3), new MobilePlayer("X"), new ComputerPlayer("O"), renderer));
        this.mobileGamesOptions.put(MobileGameMode.COMPUTER_VS_HUMAN, new MobileGame(new Board(3), new ComputerPlayer("X"), new MobilePlayer("O"), renderer));
    }
}
