package se.linda.gamecenter.Games;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import se.linda.gamecenter.Componenets.Letter;
import se.linda.gamecenter.Constructors.WordSelector;
import se.linda.gamecenter.Enums.Games;
import se.linda.gamecenter.FXbase.LetterBase;
import se.linda.gamecenter.Functions.Alerts;

import java.util.ArrayList;
import java.util.List;

public class WordGuesser implements BaseGame {
    private final Pane mainGrid;
    private final Scene scene;
    private final LetterBase letterBase;
    private final List<String> guessedLetters = new ArrayList<>();
    private final List<Integer> letterIndexes = new ArrayList<>();
    private final String hiddenWord;
    private Alerts alerts;

    public WordGuesser() {
        this.letterBase = new LetterBase(new WordSelector().getWord());
        this.mainGrid = letterBase.init();
        this.scene = new Scene(mainGrid);
        this.hiddenWord = letterBase.getWord();
        setAlert();
        setLogic();
    }

    private void setAlert() {
        alerts = new Alerts("Congratulations!", "You guessed the word: " + hiddenWord, Alert.AlertType.NONE);
    }


    private String[] parseGuess(String userInput) {
        return userInput.strip().split("");
    }

    private void countLetters(String userLetter) {
        letterIndexes.clear();
        for (int index = hiddenWord.indexOf(userLetter); index >= 0; index = hiddenWord.indexOf(userLetter, index +1)) {
            letterIndexes.add(index);
        }
    }

    private void addLetter(String userGuess) {
        if (!guessedLetters.contains(userGuess)) {
            guessedLetters.add(userGuess);
        }
    }

    private void flipCorrectGuess(String letterGuess) {
        if (hiddenWord.contains(letterGuess)) {
            countLetters(letterGuess);
            for (Integer index : letterIndexes) {
                Letter temp = (Letter) mainGrid.lookup("#" + index + letterGuess);
                if (temp.getHidden()) {
                    temp.flipHidden();
                }
            }
        } else {
            letterBase.getGuessField().setText(letterBase.getGuessField().getText() + letterGuess + " ");
        }
    }

    private void checkGuess(String userGuess) {
        addLetter(userGuess);
        for (String letterGuess : parseGuess(userGuess)) {
            flipCorrectGuess(letterGuess);
        }
    }

    private void setLogic() {
        letterBase.getTextField().setOnKeyPressed( key -> {
            if (key.getCode() == KeyCode.ENTER && !letterBase.getTextField().getText().isEmpty()) {
                String input = letterBase.getTextField().getText();
                checkGuess(input);
                letterBase.getTextField().clear();
                checkVictory();
            }
        });
        letterBase.getTextField().textProperty().addListener((observable, oldValue, newValue) -> {
            if ((newValue.length() == 1 && !newValue.matches("[a-zA-Z]*")) || guessedLetters.contains(newValue)) {
                letterBase.getTextField().clear();
            } else if (newValue.length() > 1) {
                letterBase.getTextField().setText(newValue.substring(0, 1));
            }
        });
    }

    public void checkVictory() {
        String[] word = hiddenWord.strip().split("");
        StringBuilder tempHiddenWord = new StringBuilder();
        for (int i = 0; i < word.length; i++) {
            Letter letter = (Letter) mainGrid.lookup("#" + i + word[i]);
            tempHiddenWord.append(letter.getText());
        }
        if (!tempHiddenWord.toString().contains("_")) {
            reRun(alerts, mainGrid, Games.WORDGUESSER.getGame());
        }
    }

    public Scene Start() {
        return scene;
    }
}