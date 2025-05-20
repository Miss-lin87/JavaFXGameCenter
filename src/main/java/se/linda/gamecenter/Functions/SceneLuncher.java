package se.linda.gamecenter.Functions;

import javafx.scene.Scene;
import se.linda.gamecenter.Games.BaseGame;

public class SceneLuncher{
    private BaseGame game;

    public SceneLuncher(BaseGame game) {
        this.game = game;
    }

    public Scene load() {
        return game.Start();
    }
}