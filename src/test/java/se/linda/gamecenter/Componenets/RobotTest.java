package se.linda.gamecenter.Componenets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.linda.gamecenter.Enums.Directions;
import se.linda.gamecenter.FXbase.GridBase;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    private Robot robot;

    @BeforeEach
    public void init(){
        robot = new Robot(2,2);
    }

    @Test
    public void CreationTest() {
        Robot temp = new Robot();
        assertAll(
                () -> assertNotNull(robot),
                () -> assertNotNull(temp),
                () -> assertEquals(2, robot.getX()),
                () -> assertEquals(2, robot.getY()),
                () -> assertEquals(0, temp.getX()),
                () -> assertEquals(0, temp.getY())
        );
    }

    @Test
    public void moveUpTest() {
        robot.move(Directions.UP);
        assertAll(
                () -> assertEquals(2, robot.getX()),
                () -> assertEquals(1, robot.getY())
        );
    }
    @Test
    public void moveDownTest() {
        robot.move(Directions.DOWN);
        assertAll(
                () -> assertEquals(2, robot.getX()),
                () -> assertEquals(3, robot.getY())
        );
    }
    @Test
    public void moveLeftTest() {
        robot.move(Directions.LEFT);
        assertAll(
                () -> assertEquals(1, robot.getX()),
                () -> assertEquals(2, robot.getY())
        );
    }
    @Test
    public void moveRightTest() {
        robot.move(Directions.RIGHT);
        assertAll(
                () -> assertEquals(3, robot.getX()),
                () -> assertEquals(2, robot.getY())
        );
    }

    @Test
    public void checkBoundsTest() {
        GridBase mockGrid = new GridBase(5,10);
        robot = new Robot(0,0);
        Robot mockRobot = new Robot(4,4);
        assertAll(
                () -> assertFalse(robot.checkBounds(Directions.UP, mockGrid)),
                () -> assertTrue(robot.checkBounds(Directions.DOWN, mockGrid)),
                () -> assertFalse(robot.checkBounds(Directions.LEFT, mockGrid)),
                () -> assertTrue(robot.checkBounds(Directions.RIGHT, mockGrid)),
                () -> assertFalse(mockRobot.checkBounds(Directions.DOWN, mockGrid)),
                () -> assertFalse(mockRobot.checkBounds(Directions.RIGHT, mockGrid))
        );
    }
}
