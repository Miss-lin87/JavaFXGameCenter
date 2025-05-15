package se.linda.gamecenter.Componenets;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import se.linda.gamecenter.Constructors.ColorSelector;

public class Card extends Rectangle {
    private int hight;
    private int width;
    private Color back;
    private Color front;
    private ColorSelector selectC;

    public Card(int height, int width, Color back) {
        this.hight = height;
        this.width = width;
        this.back = back;
        this.selectC = new ColorSelector(back);
        this.front = selectC.getColor();
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
