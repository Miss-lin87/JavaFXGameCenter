package se.linda.gamecenter.Games;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLuncher extends Application {

    @Override
    public void start(Stage stage) {
        stage.setScene(new FlipGame(10).Start());
        stage.show();
    }

}