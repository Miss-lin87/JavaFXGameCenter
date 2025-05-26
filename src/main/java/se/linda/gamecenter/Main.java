package se.linda.gamecenter;

import javafx.application.Application;
import javafx.stage.Stage;
import se.linda.gamecenter.Controllers.GameSelector;
import se.linda.gamecenter.Functions.SceneLuncher;
import java.util.Scanner;

public class Main extends Application {
    private GameSelector games = new GameSelector();
    private Scanner scanner = new Scanner(System.in);

    private String getGameSelection() {
        System.out.print("Welcome to the Game Center!\n" +
                "Please select a game to play:\n" +
                "1. Memory\n" +
                "2. Word Guesser\n" +
                "3. Flip Game\n" +
                "4. Rock Paper Scissors\n" +
                "5. Robot Game\n" +
                "6. Exit\n");
        return scanner.next();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String gameSelection = getGameSelection();
        SceneLuncher mainApp = new SceneLuncher(games.getGame(gameSelection));
        stage.setScene(mainApp.load());
        stage.show();
    }
}