package se.linda.gamecenter;

import javafx.application.Application;
import javafx.stage.Stage;
import se.linda.gamecenter.Controllers.GameSelector;
import se.linda.gamecenter.Enums.Games;
import se.linda.gamecenter.Functions.SceneLuncher;
import java.util.Scanner;

public class Main extends Application implements Constants {
    private final GameSelector gameSelector = new GameSelector(games);
    private final Scanner scanner = new Scanner(System.in);

    private String getGameSelection() {
        StringBuilder build = new StringBuilder()
                .append("Welcome to the Game Center!\n")
                .append("Please select a game to play:\n");
        for (Games game : Games.values()) {
            build.append(game.getGame())
                    .append(". ")
                    .append(game.getName())
                    .append("\n");
        }
        System.out.print(build);
        return scanner.next();
    }

    @Override
    public void start(Stage stage) throws Exception {
        String gameSelection = getGameSelection();
        SceneLuncher mainApp = new SceneLuncher(gameSelector.getGame(gameSelection));
        stage.setScene(mainApp.load());
        stage.show();
    }
}