package se.linda.gamecenter.Constructors;

import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ColorSelector {
    private final List<Color> colorList;

    public ColorSelector(Color backColor) {
        colorList = new ArrayList<>(List.of(
                Color.RED,
                Color.GREEN,
                Color.BLUE,
                Color.YELLOW,
                Color.ORANGE,
                Color.PINK,
                Color.PURPLE,
                Color.BROWN,
                Color.GRAY
        ));
        colorList.remove(backColor);
    }

    public Color getColor() {
        int randomIndex = (int) (Math.random() * colorList.size());
        return colorList.get(randomIndex);
    }
}