package se.linda.gamecenter;

import javafx.stage.Stage;
import se.linda.gamecenter.Games.RobotGame;
import se.linda.gamecenter.Games.SceneLuncher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    private SceneLuncher mainApp;

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, IOException {
        Main main = new Main();
        main.mainApp.start(new Stage());
    }
}
