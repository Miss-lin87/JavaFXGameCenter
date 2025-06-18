package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Cell;
import se.linda.gamecenter.Componenets.Robot;
import se.linda.gamecenter.Enums.Directions;
import se.linda.gamecenter.FXbase.GridBase;
import se.linda.gamecenter.Functions.Alerts;

import static se.linda.gamecenter.Enums.Directions.*;

public class RobotGame implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final GridBase gridBase;
    private Robot robotControl;
    private Alerts alerts;

    public RobotGame(int size) {
        this.gridBase = new GridBase(size, 40);
        this.mainGrid = gridBase.init(Color.GREEN);
        this.scene = new Scene(mainGrid);
        this.alerts = new Alerts("Congratulations", "You win", Alert.AlertType.NONE);
        spawnRobot(0,0);
        gameLogic();
    }

    private boolean checkMove(KeyEvent key, Directions direction) {
        return key.getCode().equals(direction.getKey()) && robotControl.checkBounds(direction, gridBase);
    }

    private void gameLogic () {
        scene.setOnKeyPressed(press -> {
            if (checkMove(press, UP)) {
                moveLogic(UP);
            } else if (checkMove(press, DOWN)) {
                moveLogic(DOWN);
            } else if (checkMove(press, LEFT)) {
                moveLogic(LEFT);
            } else if (checkMove(press, RIGHT)) {
                moveLogic(RIGHT);
            } else {
                System.out.println("out of bounds, Really?");
            }
        });
    }

    private void moveLogic(Directions direction) {
        Cell cell = (Cell) mainGrid.lookup("#" + robotControl.getX() + "|" + robotControl.getY());
        cell.flipOccupied();
        robotControl.move(direction);
        Cell cellNew = (Cell) mainGrid.lookup("#" + robotControl.getX() +"|"+ robotControl.getY());
        cellNew.flipOccupied();
    }

    private void spawnRobot(int x, int y) {
        robotControl = new Robot(x,y);
        Cell cell = (Cell) mainGrid.lookup("#" + x +"|"+ y);
        cell.flipOccupied();
    }

    public Scene Start() {
        return scene;
    }
}