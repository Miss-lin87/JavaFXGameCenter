package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Cell;
import se.linda.gamecenter.FXbase.GridBase;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    private Pane mainGrid;
    private Scene scene;
    private GridBase gridBase;

    public FlipGame(int size) {
        gridBase = new GridBase(size, 40);
        mainGrid = gridBase.init(Color.GREEN);
        scene = new Scene(mainGrid);
        gameLogic();
    }

    private void gameLogic() {
        for (int x = 0; x < gridBase.getNumberOfCells(); x++) {
            for (int y = 0; y < gridBase.getNumberOfCells(); y++) {
                Cell cell = (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + x + y)));
                setCellFunction(cell);
            }
        }
    }

    private void setCellFunction(Cell cell) {
        int tempX = Integer.parseInt(cell.getId().substring(0, 1));
        int tempY = Integer.parseInt(cell.getId().substring(1, 2));
        cell.setOnMouseClicked(_ -> {
            cell.flipOccupied();
            flipAdjacentCells(makeCellList(tempX, tempY));
        });
        cell.setOnMouseEntered(mouse -> scene.setCursor(Cursor.HAND));
    }

    private List<Cell> makeCellList(int x, int y) {
        return new ArrayList<>(List.of(
                (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + (x - 1) + y))),
                (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + (x + 1) + y))),
                (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + x + (y - 1)))),
                (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + x + (y + 1))))
        ));
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