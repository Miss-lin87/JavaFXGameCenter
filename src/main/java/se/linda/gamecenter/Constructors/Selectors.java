package se.linda.gamecenter.Constructors;

import javafx.scene.paint.Color;
import se.linda.gamecenter.Constants;
import java.util.Random;

public interface Selectors extends Constants {
    Random random = new Random();

    default String getWord() {
        return words.get(random.nextInt(words.size()));
    }

    default Color getColor() {
        return colors.get(random.nextInt(colors.size()));
    }

}
