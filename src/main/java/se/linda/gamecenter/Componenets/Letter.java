package se.linda.gamecenter.Componenets;

import javafx.scene.text.Text;

public class Letter extends Text {
    private final String letter;
    private boolean hidden;

    public Letter(String letter) {
        this.letter = letter;
        this.hidden = false;
        this.setText(letter);
    }

    public void flipHidden() {
        this.hidden = !this.hidden;
        if (hidden) {
            this.setText("_");
        } else {
            this.setText(letter);
        }
    }

    public Letter getLetter(int x) {
        this.setDisable(true);
        this.setId(x + letter);
        this.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        flipHidden();
        return this;
    }

    public boolean getHidden() {
        return this.hidden;
    }
}