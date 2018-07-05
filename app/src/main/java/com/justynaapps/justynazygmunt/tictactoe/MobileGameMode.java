package com.justynaapps.justynazygmunt.tictactoe;

public enum MobileGameMode {

    HUMAN_VS_HUMAN(2131165257),
    HUMAN_VS_COMPUTER(2131165256),
    COMPUTER_VS_HUMAN(2131165230);

    private final int value;

    MobileGameMode(int gameModeString) {
        this.value = gameModeString;
    }

    public int value() {
        return this.value;
    }
}
