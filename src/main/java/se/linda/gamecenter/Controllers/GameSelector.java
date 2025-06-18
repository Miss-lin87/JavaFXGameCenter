package se.linda.gamecenter.Controllers;

import se.linda.gamecenter.Games.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameSelector {
    private Map<String, Supplier<BaseGame>> gameSuppliers = new HashMap<>();

    public GameSelector(Map<String, Supplier<BaseGame>> gameList) {
        this.gameSuppliers = gameList;
    }

     public BaseGame getGame(String slection) {
        if (gameSuppliers.containsKey(slection)) {
            return gameSuppliers.get(slection).get();
        } else {
            throw new IllegalArgumentException("Invalid game selection: " + slection);
        }
     }
}