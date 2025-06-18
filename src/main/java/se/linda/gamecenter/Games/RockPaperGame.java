package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import se.linda.gamecenter.Componenets.Picture;
import se.linda.gamecenter.Enums.Games;
import se.linda.gamecenter.Enums.RPS;
import se.linda.gamecenter.FXbase.PicBase;
import se.linda.gamecenter.Functions.Alerts;

import java.util.*;
import static se.linda.gamecenter.Enums.RPS.*;

public class RockPaperGame implements BaseGame {
    private final PicBase picBase;
    private final GridPane mainGrid;
    private final Scene scene;
    private final Random random;
    private final List<Picture> picList = new ArrayList<>();
    private final Picture computerChoice;
    private final Text result = new Text();
    private final Map<RPS, Set<RPS>> Conditions;
    private final Text stats = new Text("0 - 0");
    private int wins = 0;
    private int loses = 0;
    private Alerts alerts;

    public RockPaperGame() {
        makePicList();
        this.picBase = new PicBase(picList, 75, 75);
        this.mainGrid = picBase.init();
        addStats();
        this.random = new Random();
        this.scene = new Scene(mainGrid);
        this.computerChoice = new Picture();
        this.Conditions = new HashMap<>(Map.of(
                ROCK, Set.of(SCISSOR),
                SCISSOR, Set.of(PAPER),
                PAPER, Set.of(ROCK)));
        this.alerts = new Alerts("", "", Alert.AlertType.NONE);
        gameLogic();
    }

    private void addComputerOptions() {
        mainGrid.add(computerChoice.getPic(75,75),0,1);
        mainGrid.add(result,0,2);
    }

    private void removeComputerOptions() {
        mainGrid.getChildren().remove(computerChoice);
        mainGrid.getChildren().remove(result);
    }

    private void addStats() {
        stats.setFont(Font.font(25));
        mainGrid.add(stats, mainGrid.getChildren().size(),0);
    }

    private void updateStats() {
        stats.setText(wins + " - " + loses);
    }

    private void makePicList() {
        for (RPS E : RPS.values()) {
            Picture tempPic = new Picture(E.getImagePath(), E.getName());
            picList.add(tempPic);
        }
    }

    private void setFunction(Picture pic, RPS userRPS) {
        pic.setOnMouseEntered(_ -> {
            scene.setCursor(Cursor.HAND);
        });
        pic.setOnMouseClicked(_ -> {
            removeComputerOptions();
            scene.setCursor(Cursor.WAIT);
            RPS computerRPS = RPS.values()[random.nextInt(3)];
            computerChoice.setPath(computerRPS.getImagePath());
            addComputerOptions();
            testVictory(userRPS, computerRPS);
        });
    }

    private void testVictory(RPS userSelection, RPS computerSelection) {
        if (userSelection.equals(computerSelection)) {
            result.setText("Its a tie");
        } else if (Conditions.get(userSelection).contains(computerSelection)) {
            wins ++;
            testWin("You Win");
        } else {
            loses ++;
            testWin("You lose");
        }
    }

    private void testWin(String message) {
        updateStats();
        result.setText(message);
        if (wins+loses == 3 && wins > loses) {
            alerts = new Alerts("Congratulations","You win with a score of: " + wins + " Wins, " + loses + " Loses", Alert.AlertType.NONE);
            reRun(alerts, mainGrid, Games.RPSGAME.getGame());
        } else if (wins+loses == 3 && wins < loses) {
            alerts = new Alerts("Sorry", "You lose with a score of: " + wins + " Wins, " + loses + " Loses", Alert.AlertType.NONE);
            reRun(alerts, mainGrid, Games.RPSGAME.getGame());
        }
    }

    private void gameLogic() {
        for (RPS rps : RPS.values()) {
            Picture tempPic = (Picture) mainGrid.lookup("#" + rps.getName());
            setFunction(tempPic, rps);
        }
    }

    public Scene Start() {
        return scene;
    }
}