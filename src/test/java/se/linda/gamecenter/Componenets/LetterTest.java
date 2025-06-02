package se.linda.gamecenter.Componenets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LetterTest {
    private Letter letter;

    @BeforeEach
    void setLetter() {
        this.letter = new Letter("a");
    }

    @Test
    void CreationTest() {
        assertAll(
                () -> assertEquals("a", letter.getText()),
                () -> assertNotEquals("b", letter.getText()),
                () -> assertFalse(letter.getHidden())
        );
    }

    @Test
    void flipHiddenTest() {
        assertEquals("a", letter.getText());
        letter.flipHidden();
        assertAll(
                () -> assertEquals("_", letter.getText()),
                () -> assertTrue(letter.getHidden()),
                () -> assertNotEquals("a", letter.getText())
        );
    }

    @Test
    void getLetterTest() {
        Letter temp = letter.getLetter(0);
        Letter temp2 = letter.getLetter(1);
        assertAll(
                () -> assertEquals("a", temp.getText()),
                () -> assertFalse(letter.getHidden()),
                () -> assertEquals("1a", temp.getId()),
                () -> assertEquals("a", temp2.getText()),
                () -> assertEquals("1a", temp2.getId())
        );
    }
}