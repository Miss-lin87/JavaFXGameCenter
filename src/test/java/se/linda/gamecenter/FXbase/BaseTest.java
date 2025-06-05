package se.linda.gamecenter.FXbase;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.linda.gamecenter.Componenets.Card;
import se.linda.gamecenter.Componenets.Cell;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    @Test
    public void testGrid() {
        GridBase temp = new GridBase(10, 10);
        assertAll(
                () -> assertNotNull(temp),
                () -> assertEquals(10, temp.getNumberOfCells()),
                () -> assertEquals(Pane.class, temp.init(Color.RED).getClass()),
                () -> assertEquals(200, temp.init(Color.RED).getChildren().size()),
                () -> assertEquals(Cell.class, temp.init(Color.RED).getChildren().get(new Random().nextInt(200)).getClass())
        );
    }

    @Test
    public void testCard() {
        CardBase temp = new CardBase(10,"10x10");
        assertAll(
                () -> assertNotNull(temp),
                () -> assertEquals(10, temp.getNumberOfCards()),
                () -> assertEquals(Pane.class, temp.init(Color.RED).getClass()),
                () -> assertEquals(20, temp.init(Color.RED).getChildren().size()),
                () -> assertEquals(Card.class, temp.init(Color.RED).getChildren().get(new Random().nextInt(10)).getClass()),
                () -> assertTrue(temp.init(Color.RED).getChildren().stream()
                        .allMatch(node -> node.getId().matches("\\d+\\d+"))));
    }

    @Test
    public void testPic() {
        PicBase temp = new PicBase(List.of(), 25,25);
        assertAll(
                () -> assertNotNull(temp),
                () -> assertEquals(PicBase.class, temp.getClass()),
                () -> assertEquals(GridPane.class, temp.init().getClass()),
                () -> assertEquals(0, temp.init().getChildren().size())
        );
    }
}
