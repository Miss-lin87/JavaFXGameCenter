package se.linda.gamecenter.Controllers;

import se.linda.gamecenter.Games.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameSelector {
    private final Map<String, Supplier<BaseGame>> gameSuppliers = new HashMap<>();

    public GameSelector() {
        this.gameSuppliers.putAll(Map.of(
                "1" , () -> new Memory(10),
                "2" , () -> new WordGuesser(),
                "3" , () -> new FlipGame(10),
                "4" , () -> {
                    try {
                        return new RockPapperGame();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                "5" , () -> new RobotGame(10)
        ));
    }

     public BaseGame getGame(String slection) {
        if (gameSuppliers.containsKey(slection)) {
            return gameSuppliers.get(slection).get();
        } else {
            throw new IllegalArgumentException("Invalid game selection: " + slection);
        }
     }
}
