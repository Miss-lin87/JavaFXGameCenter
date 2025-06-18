package se.linda.gamecenter.Controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.linda.gamecenter.Constants;
import se.linda.gamecenter.Games.*;

import java.io.InvalidObjectException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;

public class GameSelectorTest {
    private final GameSelector tempSelector;
    private final Map<String, Supplier<BaseGame>> mockList = Map.of(
            "1", () -> Mockito.mock(Memory.class),
            "2", () -> Mockito.mock(WordGuesser.class),
            "3", () -> Mockito.mock(FlipGame.class),
            "4", () -> Mockito.mock(RockPapperGame.class),
            "5", () -> Mockito.mock(RobotGame.class)
    );

    public GameSelectorTest() {
        this.tempSelector = new GameSelector(Constants.games) {
        };
    }

    @Test
    public void testCreation() {
        assertAll(
                () -> assertNotNull(tempSelector)
        );
    }

    @Test
    public void testErrors() {
        assertAll(
                () -> assertThrowsExactly(IllegalArgumentException.class, () -> tempSelector.getGame("8")),
                () -> assertThrows(IllegalArgumentException.class, () -> tempSelector.getGame("null"))
        );
    }

    @Test
    public void testRandomGetGame() {
        GameSelector mockSelector = new GameSelector(mockList);
        assertAll(
                () -> assertInstanceOf(Memory.class, mockSelector.getGame("1")),
                () -> assertEquals(Memory.class, mockSelector.getGame("1").getClass()),
                () -> assertInstanceOf(WordGuesser.class, mockSelector.getGame("2")),
                () -> assertEquals(WordGuesser.class, mockSelector.getGame("2").getClass()),
                () -> assertInstanceOf(FlipGame.class, mockSelector.getGame("3")),
                () -> assertEquals(FlipGame.class, mockSelector.getGame("3").getClass()),
                () -> assertInstanceOf(RockPapperGame.class, mockSelector.getGame("4")),
                () -> assertEquals(RockPapperGame.class, mockSelector.getGame("4").getClass()),
                () -> assertInstanceOf(RobotGame.class, mockSelector.getGame("5")),
                () -> assertEquals(RobotGame.class, mockSelector.getGame("5").getClass())
        );
    }
}