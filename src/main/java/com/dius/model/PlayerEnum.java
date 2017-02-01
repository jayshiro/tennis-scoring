package com.dius.model;

import java.util.Arrays;

/**
 * Created by Jay on 1/02/2017.
 */
public enum PlayerEnum {
    PLAYER1("Player 1"),
    PLAYER2("Player 2");

    private String displayName;

    PlayerEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PlayerEnum getByDisplayName(String displayName) {
        return Arrays.stream(PlayerEnum.values())
                .filter(p -> p.getDisplayName().equals(displayName))
                .findFirst()
                .orElseThrow(() -> new NullPointerException());
    }
}
