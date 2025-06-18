package se.linda.gamecenter;

import javafx.scene.paint.Color;
import se.linda.gamecenter.Games.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.function.Supplier;

public interface Constants {

    Map<String, Supplier<BaseGame>> games = Map.of(
            "1" , () -> new Memory(10),
            "2" , WordGuesser::new,
            "3" , () -> new FlipGame(10),
            "4" , RockPaperGame::new,
            "5" , () -> new RobotGame(10)
    );
    Properties prop = getProperties();
    String wordPath = getProperty("path.words");
    String colorPath = getProperty("path.colors");
    List<String> words = getWords();
    List<Color> colors = getColors();


    private static Properties getProperties() {
        Properties temp = new Properties();
        try {
            temp.load(new FileInputStream(System.getProperty("user.dir") + "\\settings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }

    private static String getProperty(String key) {
        return prop.getProperty(key);
    }

    private static List<Color> getColors() {
        List<Color> colors = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(colorPath));
            while (scanner.hasNextLine()) {
                String colorString = scanner.nextLine().trim();
                if (!colorString.isBlank()) {
                    colors.add(Color.valueOf(colorString.toUpperCase()));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return colors;
    }

    private static List<String> getWords() {
        List<String> words = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(wordPath));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim();
                if (!word.isBlank()) {
                    words.add(word.toLowerCase());
                }
            }
        } catch (Exception e) {
            return words;
        }
        return words;
    }
}
