package se.linda.gamecenter.Constructors;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectorsTest implements Selectors {

    @Test
    public void ColorSelectionTest() {
        for (int i = 0; i < 100; i ++) {
            assertEquals(Color.class, getColor().getClass());
        }
    }
    @Test
    public void wordSelectionTest() {
        for (int i = 0; i < 100; i ++) {
            assertEquals(String.class, getWord().getClass());
        }
    }
}