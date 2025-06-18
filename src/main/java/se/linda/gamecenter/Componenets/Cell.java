package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
    private boolean isOccupied;
    private final int cellSize;
    private final Color color;

    public Cell (int cellSize, Color color) {
        this.isOccupied = false;
        this.cellSize = cellSize;
        this.setWidth(cellSize);
        this.setHeight(cellSize);
        this.color = color;
        this.setFill(color);
    }

    public Cell getCell(int x, int y) {
        setTranslateX(x * cellSize);
        setTranslateY(y * cellSize);
        this.setStroke(Color.WHITE);
        this.setId(x + "|" + y);
        return this;
    }

    public void flipOccupied() {
        this.isOccupied = !this.isOccupied;
        if (isOccupied) {
            this.setFill(Color.RED);
        } else {
            this.setFill(color);
        }
    }
}