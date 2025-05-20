package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Card extends Rectangle {
    private final int hight;
    private final int width;
    private final Color back;
    private final Color front;

    public Card(int height, int width, Color back, Color front) {
        this.hight = height;
        this.width = width;
        this.back = back;
        this.front = front;
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(back);
    }

    public Card getCard(int x, int y) {
        setTranslateX(x * width);
        setTranslateY(y * hight);
        this.setStroke(Color.WHITE);
        this.setStrokeWidth(5);
        this.setId(x + "" + y);
        return this;
    }

    public void flipCard() {
        if (this.getFill() == back) {
            this.setFill(front);
        } else {
            this.setFill(back);
        }
    }
}
