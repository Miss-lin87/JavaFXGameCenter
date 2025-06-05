package se.linda.gamecenter.Constructors;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectorsTest {
    private ColorSelector CS;
    private WordSelector WS;
    private List<Color> colorlist = List.of(
            Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW,
            Color.ORANGE,
            Color.PINK,
            Color.PURPLE,
            Color.BROWN,
            Color.GRAY);
    private List<String> wordList = List.of(
            "apple",
            "banana",
            "cherry",
            "date",
            "elderberry",
            "fig",
            "grape",
            "honeydew",
            "kiwi",
            "lemon"
    );

    @BeforeEach
    public void init() {
        this.CS = new ColorSelector(Color.RED);
        this.WS = new WordSelector();
    }

    @Test
    public void ColorSelectionTest() {
        for (int i = 0; i < 100; i ++) {
            assertTrue(colorlist.contains(CS.getColor()));
        }
    }
    @Test
    public void wordSelectionTest() {
        for (int i = 0; i < 100; i ++) {
            assertTrue(wordList.contains(WS.getWord()));
        }
    }
}