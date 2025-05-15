package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Cell;
import se.linda.gamecenter.Componenets.Robot;
import se.linda.gamecenter.Enums.Directions;
import se.linda.gamecenter.FXbase.GridBase;

import static se.linda.gamecenter.Enums.Directions.*;
import static se.linda.gamecenter.Enums.Directions.LEFT;
import static se.linda.gamecenter.Enums.Directions.RIGHT;

public class RobotGame {
    private Pane mainGrid;
    private Scene scene;
    private Robot robotControll;
    private GridBase gridBase;

    public RobotGame(int size) {
        gridBase = new GridBase(size, 40);
        mainGrid = gridBase.init(Color.GREEN);
        scene = new Scene(mainGrid);
        spawnRobot(0,0);
        setKeyLogic(scene);
    }

    private boolean checkMove(KeyEvent key, Directions direction) {
        return key.getCode().equals(direction.getKey()) && robotControll.checkBounds(direction, gridBase);
    }

    private void setKeyLogic (Scene scene) {
        scene.setOnKeyPressed(press -> {
            if (checkMove(press, UP)) {
                moveLogic(UP);
            }
            if (checkMove(press, DOWN)) {
                moveLogic(DOWN);
            }
            if (checkMove(press, LEFT)) {
                moveLogic(LEFT);
            }
            if (checkMove(press, RIGHT)) {
                moveLogic(RIGHT);
            }
        });
    }

    private void moveLogic(Directions direction) {
        Cell cell = (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + robotControll.getX() + robotControll.getY())));
        cell.flipOccupied();
        robotControll.move(direction);
        cell = (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + robotControll.getX() + robotControll.getY())));
        cell.flipOccupied();
    }

    private void spawnRobot(int x, int y) {
        robotControll = new Robot(x,y);
        Cell cell = (Cell) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + x + y)));
        cell.flipOccupied();
    }

    public Scene Start() {
        return scene;
    }
}
