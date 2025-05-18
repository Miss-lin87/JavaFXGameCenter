package se.linda.gamecenter.Constructors;

import java.util.List;

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
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }
}
