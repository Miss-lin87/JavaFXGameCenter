package se.linda.gamecenter.FXbase;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.Getter;
import se.linda.gamecenter.Componenets.Card;

public class CardBase {
    private final Pane mainGrid;
    @Getter
    private final int numberOfCards;
    private int cardHight;
    private int cardWidth;

    public CardBase(int numberOfCards, String cardSize) {
        this.mainGrid = new Pane();
        this.numberOfCards = numberOfCards;
        parseCardSize(cardSize);
    }

    private void parseCardSize(String cardSize) {
        String[] input = cardSize.strip().split("x");
        cardHight = Integer.parseInt(input[0]);
        cardWidth = Integer.parseInt(input[1]);
    }

    private double getPrefSize(int cellSize, int numberOfCards) {
        return (double) cellSize * numberOfCards;
    }

    private void setGrid(Color color) {
        mainGrid.setPrefSize(getPrefSize(cardWidth, numberOfCards), getPrefSize(cardHight, numberOfCards));
        for (int x = 0; x < numberOfCards; x++) {
            for (int y = 0; y < numberOfCards; y++) {
                Card card = new Card(cardHight, cardWidth, color);
                mainGrid.getChildren().add(card.getCard(x,y));
            }
        }
    }

    public Pane init(Color color) {
        setGrid(color);
        return mainGrid;
    }
}
