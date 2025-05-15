package se.linda.gamecenter.Games;

import javafx.scene.Scene;

public class SceneLuncher{
    private BaseGame game;

    public SceneLuncher(BaseGame game) {
        this.game = game;
    }

    public Scene load() {
        return game.Start();
    }
}