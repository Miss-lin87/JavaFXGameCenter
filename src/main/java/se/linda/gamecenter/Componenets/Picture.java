package se.linda.gamecenter.Componenets;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Picture extends Rectangle {
    private String Letter;
    private boolean hidden;

    public Picture(Image fill) {
        this.Letter = letter;
        this.hidden = false;
    }

    public void flipHidden() {
        this.hidden = !this.hidden;
        if (hidden) {
            this.setText("_");
        } else {
            this.setText(Letter);
        }
    }

    public Letter getLetter(int x, String letter) {
        this.setText(Letter);
        this.setDisable(true);
        this.setId(x + letter);
        this.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        flipHidden();
        return this;
    }
}
