package se.linda.gamecenter.FXbase;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import lombok.Getter;
import se.linda.gamecenter.Componenets.Letter;

public class LetterBase {
    private final GridPane mainGrid;
    @Getter
    private final TextField textField;
    @Getter
    private final TextArea guessField;
    @Getter
    private final String word;

    public LetterBase(String word) {
        this.mainGrid = new GridPane();
        this.textField = new TextField();
        this.guessField = new TextArea();
        this.word = word;
    }

    private String[] parseWord() {
        return word.strip().split("");
    }

    private void setGrid() {
        mainGrid.setPrefSize(250, 250);
        mainGrid.setHgap(10);
        String[] tempWord = parseWord();
        int position = 0;
        for (String letter : tempWord) {
            Letter l = new Letter(letter);
            mainGrid.add(l.getLetter(position,letter),position,0);
            position ++;
        }
        mainGrid.add(textField, 0,1,tempWord.length,1);
        guessField.setEditable(false);
        guessField.setWrapText(true);
        guessField.setPrefSize(50,50);
        mainGrid.add(guessField, 0,2, tempWord.length,1);
    }

    public Pane init() {
        setGrid();
        return mainGrid;
    }
}
