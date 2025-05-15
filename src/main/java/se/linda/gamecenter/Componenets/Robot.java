package se.linda.gamecenter.Componenets;

import se.linda.gamecenter.Enums.Directions;
import se.linda.gamecenter.FXbase.GridBase;

public class Robot {
    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public Robot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Directions direction) {
        switch (direction) {
            case UP -> y--;
            case DOWN -> y++;
            case LEFT -> x--;
            case RIGHT -> x++;
        }
    }

    public boolean checkBounds(Directions direction, GridBase grid) {
        int tempX = x;
        int tempY = y;

        switch (direction) {
            case UP -> tempY--;
            case DOWN -> tempY++;
            case LEFT -> tempX--;
            case RIGHT -> tempX++;
        }
        return tempY >= 0 && tempY < grid.getNumberOfCells() && tempX >= 0 && tempX < grid.getNumberOfCells();
    }
}
