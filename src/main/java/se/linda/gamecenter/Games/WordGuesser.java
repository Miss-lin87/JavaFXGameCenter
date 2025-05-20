package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import se.linda.gamecenter.Componenets.Letter;
import se.linda.gamecenter.Constructors.WordSelector;
import se.linda.gamecenter.FXbase.LetterBase;

import java.util.ArrayList;
import java.util.List;

public class WordGuesser implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final LetterBase letterBase;

    public WordGuesser() {
        letterBase = new LetterBase(new WordSelector().getWord());
        mainGrid = letterBase.init();
        scene = new Scene(mainGrid);
        setLogic();
    }

    private String[] parseGuess(String userInput) {
        return userInput.strip().split("");
    }

    private List<Integer> countLetters(String userLetter) {
        List<Integer> indexes = new ArrayList<>();
        String word = letterBase.getWord();
        for (int index = word.indexOf(userLetter); index >= 0; index = word.indexOf(userLetter, index +1)) {
            indexes.add(index);
        }
        return indexes;
    }

    private void checkGuess(String userGuess) {
        String word = letterBase.getWord();
        for (String letterGuess : parseGuess(userGuess)) {
            if (word.contains(letterGuess)) {
                List<Integer> indexes = countLetters(letterGuess);
                for (Integer index : indexes) {
                    Letter temp = (Letter) mainGrid.lookup("#" + index + letterGuess);
                    temp.flipHidden();
                }
            }
        }
    }

    private void setLogic() {
        letterBase.getTextField().setOnKeyPressed( key -> {
            if (key.getCode() == KeyCode.ENTER) {
                String input = letterBase.getTextField().getText();
                checkGuess(input);
                letterBase.getTextField().clear();
            }
        });
        letterBase.getTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 1) {
                letterBase.getTextField().setText(newValue.substring(0, 1));
            }
        });
    }

    public Scene Start() {
        return scene;
    }
}
