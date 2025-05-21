package se.linda.gamecenter.Componenets;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import lombok.Getter;

public class Picture extends Rectangle {
    private Image image;
    @Getter
    private String name;
    private int id;

    public Picture (String path, String name) {
        this.image = new Image(path);
        this.name = name;
    }

    public Picture getPic(int height, int with) {
        this.setHeight(height);
        this.setWidth(with);
        this.setFill(new ImagePattern(image));
        this.setId(name);
        return this;
    }
}
