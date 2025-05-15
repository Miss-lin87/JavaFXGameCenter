package se.linda.gamecenter.FXbase;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import lombok.Getter;
import se.linda.gamecenter.Componenets.Letter;

public class LetterBase {
    private final Pane mainGrid;
    private final TextArea textArea;
    @Getter
    private final String word;

    public LetterBase(String word) {
        this.mainGrid = new Pane();
        this.textArea = new TextArea();
        this.word = word;
    }

    private String[] parseWord() {
        String[] input = word.strip().split("");
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            sb.append(s).append(",");
        }
        return sb.toString().strip().split(",");
    }

    private void setGrid() {
        mainGrid.setPrefSize(250, 250);
        String[] tempWord = parseWord();
        int position = 0;
        for (String letter : tempWord) {
            Letter l = new Letter(letter);
            mainGrid.getChildren().add(l.getLetter(0, position));
            position ++;
        }
        Text temp = new Text();
        temp.setText("WORD");
        mainGrid.getChildren().add(temp);
    }

    public Pane init() {
        setGrid();
        return mainGrid;
    }
}
