package se.linda.gamecenter.Games;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import se.linda.gamecenter.Componenets.Card;
import se.linda.gamecenter.Componenets.Picture;
import se.linda.gamecenter.Enums.RPS;
import se.linda.gamecenter.FXbase.PicBase;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RockPapperGame implements BaseGame {
    private final PicBase picBase;
    private final GridPane mainGrid;
    private final Scene scene;
    private final Random random;
    private final List<Picture> picList = new ArrayList<>();


    public RockPapperGame(String size) throws IOException {
        makePicList();
        this.picBase = new PicBase(picList, 75, 75);
        this.mainGrid = picBase.init();
        this.random = new Random();
        this.scene = new Scene(mainGrid);
        gameLogic();
    }

    private void addComputerOptions() {

    }

    private void makePicList() {
        for (RPS E : RPS.values()) {
            Picture tempPic = new Picture(E.getImagePath(), E.getName());
            picList.add(tempPic);
        }
    }

    private void setFunction(Picture pic) {
        //scene.getStylesheets().add("Styles.css");
        //pic.setOnMouseClicked(click -> pic.getStyleClass().add("pic-frame"));
        pic.setOnMouseEntered(event -> scene.setCursor(Cursor.HAND));
        pic.setOnMouseClicked(select -> {
            scene.setCursor(Cursor.WAIT);

            testVictory(pic.getName(), RPS.values()[random.nextInt(3)].getName());
        });
        //pic.setOnMouseClicked(click -> pic.setStyle("-fx-stroke: black"));
    }

    private boolean testVictory(String userSelection, String computerSelection) {
        System.out.println(userSelection + "|" + computerSelection);
        return false;
    }

    private void gameLogic() {
        for (RPS rps : RPS.values()) {
            Picture tempPic = (Picture) mainGrid.lookup("#" + rps.getName());
            setFunction(tempPic);
        }
    }

    public Scene Start() {
        return scene;
    }
}
