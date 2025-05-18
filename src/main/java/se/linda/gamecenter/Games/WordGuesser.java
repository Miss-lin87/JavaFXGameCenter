package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import se.linda.gamecenter.Componenets.Letter;
import se.linda.gamecenter.FXbase.LetterBase;

import java.util.ArrayList;
import java.util.List;

public class WordGuesser implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final LetterBase letterBase;

    public WordGuesser(String word) {
        letterBase = new LetterBase(word);
        mainGrid = letterBase.init();
        scene = new Scene(mainGrid);
        setLogic();
    }

    private String[] parseGuess(String userInput) {
        return userInput.strip().split("");
    }

    private List<Integer> countLetters(String userLetter) {
        List<Integer> indexes = new ArrayList<>();
        for (String letter : letterBase.getWord().split("")) {
            if (letter.equals(userLetter)) {
            }
            indexes.add(letterBase.getWord().indexOf(letter));
        }
        System.out.println(indexes);
        return indexes;
    }

    private void checkGuess(String userGuess) {
        String word = letterBase.getWord();
        for (String letterGuess : parseGuess(userGuess)) {
            if (word.contains(letterGuess)) {
                List<Integer> indexes = countLetters(letterGuess);
                for (Integer index : indexes) {
                    Letter temp = (Letter) mainGrid.getChildren().get(mainGrid.getChildren().indexOf(mainGrid.lookup("#" + index + letterGuess)));
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
    }

    public Scene Start() {
        return scene;
    }
}
