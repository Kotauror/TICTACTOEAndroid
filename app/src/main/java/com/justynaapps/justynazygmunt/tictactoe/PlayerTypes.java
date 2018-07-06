package com.justynaapps.justynazygmunt.tictactoe;

public enum PlayerTypes {

    HUMAN("1"),
    COMPUTER("2");

    private final String value;

    PlayerTypes(String playerType) {
        this.value = playerType;
    }

    public String value() {
        return this.value;
    }

}
