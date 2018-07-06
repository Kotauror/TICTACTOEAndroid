package com.justynaapps.justynazygmunt.tictactoe;

public enum MobileGameMode {

    HUMAN_VS_HUMAN("11"),
    HUMAN_VS_COMPUTER("12"),
    COMPUTER_VS_HUMAN("21");

    private final String value;

    MobileGameMode(String gameModeString) {
        this.value = gameModeString;
    }

    public String value() {
        return this.value;
    }
}
