package se.linda.gamecenter.Constructors;

import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        int randomIndex = new Random().nextInt(colorList.size());
        return colorList.get(randomIndex);
    }
}