package se.linda.gamecenter.Controllers;

import se.linda.gamecenter.Constants;
import se.linda.gamecenter.Games.*;

import java.util.Map;
import java.util.function.Supplier;

public class GameSelector {
    private final Map<String, Supplier<BaseGame>> games;

    public GameSelector(Map<String, Supplier<BaseGame>> list) {
        this.games = list;
    }

     public BaseGame getGame(String selection) {
        if (games.containsKey(selection)) {
            return games.get(selection).get();
        } else {
            throw new IllegalArgumentException("Invalid game selection: " + selection);
        }
     }
}