package se.linda.gamecenter.Enums;

import javafx.scene.input.KeyCode;

public enum Directions {
    UP (KeyCode.UP),
    DOWN (KeyCode.DOWN),
    LEFT (KeyCode.LEFT),
    RIGHT (KeyCode.RIGHT),;

    private KeyCode key;

    Directions(KeyCode key) {
        this.key = key;
    }

    public KeyCode getKey() {
        return key;
    }
}
