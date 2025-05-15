package se.linda.gamecenter;

import javafx.application.Application;
import javafx.stage.Stage;
import se.linda.gamecenter.Games.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application {
    private SceneLuncher mainApp;


    @Override
    public void start(Stage stage) throws Exception {
        mainApp = new SceneLuncher(new WordGuesser("HELLO"));
        stage.setScene(mainApp.load());
        stage.show();
    }
}
