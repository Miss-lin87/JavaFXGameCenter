package se.linda.gamecenter.FXbase;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Getter;
import se.linda.gamecenter.Componenets.Cell;

public class GridBase {
    private final Pane mainGrid;
    @Getter
    private final int numberOfCells;
    private final int cellSize;

    public GridBase(int numberOfCells, int cellSize) {
        this.mainGrid = new Pane();
        this.numberOfCells = numberOfCells;
        this.cellSize = cellSize;
    }

    private double getPrefSize(int cellSize, int numberOfCells) {
        return (double) cellSize * numberOfCells;
    }

    private void setGrid(Color color) {
        mainGrid.setPrefSize(getPrefSize(cellSize, numberOfCells), getPrefSize(cellSize, numberOfCells));
        for (int x = 0; x < numberOfCells; x++) {
            for (int y = 0; y < numberOfCells; y++) {
                Cell cell = new Cell(cellSize, color);
                mainGrid.getChildren().add(cell.getCell(x,y));
            }
        }
    }

    public Pane init(Color color) {
        setGrid(color);
        return mainGrid;
    }
}
