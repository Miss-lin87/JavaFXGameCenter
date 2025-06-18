package se.linda.gamecenter;

import se.linda.gamecenter.Games.*;

import java.util.Map;
import java.util.function.Supplier;

public class Constants {
    public static final Map<String, Supplier<BaseGame>> games = Map.of(
            "1" , () -> new Memory(10),
            "2" , () -> new WordGuesser(),
            "3" , () -> new FlipGame(10),
            "4" , () -> new RockPapperGame(),
            "5" , () -> new RobotGame(10)
        );
}
