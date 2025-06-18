package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Cell;
import se.linda.gamecenter.Enums.Games;
import se.linda.gamecenter.Enums.GridMovment;
import se.linda.gamecenter.FXbase.GridBase;
import se.linda.gamecenter.Functions.Alerts;

import java.util.ArrayList;
import java.util.List;
import static se.linda.gamecenter.Enums.GridMovment.*;

public class FlipGame implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final GridBase gridBase;
    private final Alerts alerts;

    public FlipGame(int size) {
        this.gridBase = new GridBase(size, 40);
        this.mainGrid = gridBase.init(Color.GREEN);
        this.scene = new Scene(mainGrid);
        this.alerts = new Alerts("Congratulations!", "You flipped all the tiles", Alert.AlertType.NONE);
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
            checkVictory();
        });
        cell.setOnMouseEntered(_ -> scene.setCursor(Cursor.HAND));
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

    public void checkVictory() {
        boolean win = true;
        for (Node N : mainGrid.getChildrenUnmodifiable()) {
            Cell cell = (Cell) mainGrid.lookup("#" + N.getId());
            if (!cell.getFill().equals(Color.RED)) {
                win = false;
                break;
            }
        }
        if (win) {
            reRun(alerts, mainGrid, Games.FLIPGAME.getGame());
        }
    }

    public Scene Start() {
        return scene;
    }
}