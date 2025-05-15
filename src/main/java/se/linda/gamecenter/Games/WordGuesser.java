package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import se.linda.gamecenter.Componenets.Robot;
import se.linda.gamecenter.FXbase.GridBase;
import se.linda.gamecenter.FXbase.LetterBase;

public class WordGuesser implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final LetterBase letterBase;

    public WordGuesser(String word) {
        letterBase = new LetterBase(word);
        mainGrid = letterBase.init();
        scene = new Scene(mainGrid);
    }

    @Override
    public Scene Start() {
        return scene;
    }
}
