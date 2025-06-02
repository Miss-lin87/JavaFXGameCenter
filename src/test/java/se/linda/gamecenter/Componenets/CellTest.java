package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;

    @BeforeEach
    void setCell(){
        this.cell = new Cell(25, Color.GREEN);
    }

    @Test
    void CreatonTest(){
        Cell temp = new Cell(25, Color.RED);
        assertAll(
                () -> assertNotNull(cell),
                () -> assertNotEquals(cell,temp),
                () -> assertEquals(Color.RED, temp.getFill())
        );

    }

    @Test
    void flipOccupiedTest(){
        assertEquals(Color.GREEN, cell.getFill());
        cell.flipOccupied();
        assertAll(
                () -> assertEquals(Color.RED, cell.getFill()),
                () -> assertNotEquals(Color.GREEN, cell.getFill())
        );
    }

    @Test
    void getCellTest(){
        Cell temp = cell.getCell(0,0);
        Cell temp2 = cell.getCell(1,1);
        assertAll(
                () -> assertEquals(temp,temp2),
                () -> assertSame(temp,cell),
                () -> assertEquals(Color.GREEN, temp.getFill()),
                () -> assertEquals(Color.GREEN, temp2.getFill()),
                () -> assertEquals("1|1", temp.getId()),
                () -> assertEquals("1|1", temp2.getId())
        );
    }
}