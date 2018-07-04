package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.ComputerPlayer;
import com.core.tictactoe.Player;

public class MobilePlayersFactory {

    MobilePlayersFactory() {}

    public static Player[] getPlayers(int gameModeOption) {
        if (gameModeOption == 2131165256) {
            MobilePlayer mobilePlayer1 = new MobilePlayer("X");
            MobilePlayer mobilePlayer2 = new MobilePlayer("O");
            Player[] players = {mobilePlayer1, mobilePlayer2};
            return players;
        } else {
            MobilePlayer mobilePlayer1 = new MobilePlayer("X");
            ComputerPlayer computerPlayer = new ComputerPlayer("O");
            Player[] players = {mobilePlayer1, computerPlayer};
            return players;
        }
    }
}



