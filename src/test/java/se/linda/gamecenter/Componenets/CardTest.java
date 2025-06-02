package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CardTest {
    private Card card;

    @BeforeEach
    void setCard(){
         this.card = new Card(25,25,Color.GREEN, Color.RED);
    }

    @Test
    void CreationTest() {
        Card temp = new Card(25,25,Color.AQUA, Color.WHITE);
        assertAll(
                () -> assertNotEquals(temp, card),
                () -> assertEquals(Color.AQUA, temp.getFill()),
                () -> assertEquals(25, temp.getHeight()),
                () -> assertEquals(25, temp.getWidth())
        );
    }

    @Test
    void FlipTest(){
        assertEquals(Color.GREEN, card.getFill());
        card.flipCard();
        Assertions.assertAll(
                () -> assertEquals(Color.RED, card.getFill()),
                () -> assertNotEquals(Color.GREEN, card.getFill())
        );
    }

    @Test
    void getCardTest(){
        Card temp = card.getCard(0,0);
        Assertions.assertAll(
                () -> assertEquals(Color.GREEN, temp.getFill()),
                () -> assertEquals(0, temp.getLayoutX()),
                () -> assertEquals(0, temp.getLayoutY()),
                () -> assertEquals("00", temp.getId())
        );
    }
}