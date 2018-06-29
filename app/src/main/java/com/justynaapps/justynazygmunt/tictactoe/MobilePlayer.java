package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.CommandLineUi;
import com.core.tictactoe.Player;

public class MobilePlayer extends Player {

    private String sign;

    public MobilePlayer(String sign) {
        this.sign = sign;
    }

    @Override
    public int pickPosition(CommandLineUi commandLineUi, Board board) {
        return 0;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String getSign() {
        return this.sign;
    }
}
