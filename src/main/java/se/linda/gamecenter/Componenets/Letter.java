package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Letter extends Text {
    private String Letter;
    private boolean hidden;

    public Letter(String letter) {
        this.Letter = letter;
        this.hidden = false;
    }

    public void hideLetter() {
        this.hidden = !this.hidden;
        if (hidden) {
            this.setText("_");
        } else {
            this.setText(Letter);
        }
    }

    public Letter getLetter(int x, int y) {
        setTranslateX(x * 25);
        setTranslateY(y * 25);
        this.setStroke(Color.BLACK);
        this.setId(x + "" + y);
        //hideLetter();
        return this;
    }
}