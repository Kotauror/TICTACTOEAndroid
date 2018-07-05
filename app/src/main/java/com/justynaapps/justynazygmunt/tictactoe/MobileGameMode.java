package com.justynaapps.justynazygmunt.tictactoe;

public enum MobileGameMode {

    HUMAN_VS_HUMAN(0),
    HUMAN_VS_COMPUTER(1),
    COMPUTER_VS_HUMAN(2);

    private final int value;

    MobileGameMode(int gameModeString) {
        this.value = gameModeString;
    }

    public int value() {
        return this.value;
    }
}
