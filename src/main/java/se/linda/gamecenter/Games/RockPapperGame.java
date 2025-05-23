package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import se.linda.gamecenter.Componenets.Picture;
import se.linda.gamecenter.Enums.RPS;
import se.linda.gamecenter.FXbase.PicBase;
import java.io.IOException;
import java.util.*;
import static se.linda.gamecenter.Enums.RPS.*;

public class RockPapperGame implements BaseGame {
    private final PicBase picBase;
    private final GridPane mainGrid;
    private final Scene scene;
    private final Random random;
    private final List<Picture> picList = new ArrayList<>();
    private final Picture computerChoice;
    private final Text result = new Text("Test");
    private final Map<RPS, Set<RPS>> Conditions;


    public RockPapperGame(String size) throws IOException {
        makePicList();
        this.picBase = new PicBase(picList, 75, 75);
        this.mainGrid = picBase.init();
        this.random = new Random();
        this.scene = new Scene(mainGrid);
        this.computerChoice = new Picture();
        this.Conditions = new HashMap<>(Map.of(
                ROCK, Set.of(SCISSOR),
                SCISSOR, Set.of(PAPER),
                PAPER, Set.of(ROCK)));
        gameLogic();
    }

    private void addComputerOptions() {
        mainGrid.add(computerChoice.getPic(75,75),0,1);
        mainGrid.add(result,0,2);
    }

    private void removeComputerOptions() {
    }

    private void makePicList() {
        for (RPS E : RPS.values()) {
            Picture tempPic = new Picture(E.getImagePath(), E.getName());
            picList.add(tempPic);
        }
    }

    private void setFunction(Picture pic, RPS userRPS) {
        pic.setOnMouseEntered(event -> scene.setCursor(Cursor.HAND));
        pic.setOnMouseClicked(select -> {
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
            result.setText("You Win");
        } else {
            result.setText("You lose");
        }
    }

    private void gameLogic() {
        for (RPS rps : RPS.values()) {
            Picture tempPic = (Picture) mainGrid.lookup("#" + rps.getName());
            System.out.println(tempPic.getName());
            setFunction(tempPic, rps);
        }
    }

    public Scene Start() {
        return scene;
    }
}
