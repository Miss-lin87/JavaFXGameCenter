package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Cell;
import se.linda.gamecenter.Enums.GridMovment;
import se.linda.gamecenter.FXbase.GridBase;

import java.util.ArrayList;
import java.util.List;
import static se.linda.gamecenter.Enums.GridMovment.*;

public class FlipGame implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final GridBase gridBase;

    public FlipGame(int size) {
        gridBase = new GridBase(size, 40);
        mainGrid = gridBase.init(Color.GREEN);
        scene = new Scene(mainGrid);
        gameLogic();
    }

    private void gameLogic() {
        for (int x = 0; x < gridBase.getNumberOfCells(); x++) {
            for (int y = 0; y < gridBase.getNumberOfCells(); y++) {
                Cell cell = (Cell) mainGrid.lookup("#" + x + "|" + y);
                setCellFunction(cell);
            }
        }
    }

    private void setCellFunction(Cell cell) {
        int tempX = Integer.parseInt(cell.getId().substring(0, 1));
        int tempY = Integer.parseInt(cell.getId().substring(2, 3));
        cell.setOnMouseClicked(_ -> {
            cell.flipOccupied();
            flipAdjacentCells(makeCellList(tempX, tempY));
        });
        cell.setOnMouseEntered(mouse -> scene.setCursor(Cursor.HAND));
    }

    private Cell findCell(int x, int y) {
        return (Cell) mainGrid.lookup("#" + x + "|" + y);
    }

    private List<Cell> makeCellList(int x, int y) {
        List<Cell> cellList = new ArrayList<>();
        for (GridMovment E : values()) {
            try {
                cellList.add(findCell(x+E.getCoordinates()[0], y+E.getCoordinates()[1]));
            } catch (IndexOutOfBoundsException e) {
                // Ignore out of bound
            }
        }
        return cellList;
    }

    private void flipAdjacentCells(List<Cell> cellList) {
        for (Cell cell : cellList) {
            if (cell != null) {
                cell.flipOccupied();
            }
        }
    }

    public Scene Start() {
        return scene;
    }
}