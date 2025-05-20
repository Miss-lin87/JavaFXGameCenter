package se.linda.gamecenter.Constructors;

import java.util.List;
import java.util.Random;

public class WordSelector {
    private final List<String> words;

    public WordSelector() {
        words = List.of(
                "apple",
                "banana",
                "cherry",
                "date",
                "elderberry",
                "fig",
                "grape",
                "honeydew",
                "kiwi",
                "lemon"
        );
    }

    public String getWord() {
        int randomIndex = new Random().nextInt(words.size());
        return words.get(randomIndex);
    }
}
