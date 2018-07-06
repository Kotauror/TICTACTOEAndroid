package com.justynaapps.justynazygmunt.tictactoe;

import com.core.tictactoe.Board;
import com.core.tictactoe.Player;

public class MobilePlayer extends Player {

    public MobilePlayer(String sign) {
        super(sign, null);
    }

    @Override
    public int pickPosition(Board board) {
        return 0;
    }

    @Override
    public String getType() {
        return "MobilePlayer";
    }
}
