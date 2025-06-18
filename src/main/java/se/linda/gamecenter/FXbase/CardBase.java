package se.linda.gamecenter.FXbase;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Card;
import se.linda.gamecenter.Constructors.Selectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardBase implements Selectors {
    private final Pane mainGrid;
    private int numberOfCards;
    private int cardHeight;
    private int cardWidth;
    private final List<Card> allCards;
    private final Random random = new Random();

    public CardBase(int numberOfCards, String cardSize) {
        this.mainGrid = new Pane();
        this.numberOfCards = numberOfCards;
        this.allCards = new ArrayList<>();
        parseCardSize(cardSize);
    }

    private void parseCardSize(String cardSize) {
        String[] input = cardSize.strip().split("x");
        cardHeight = Integer.parseInt(input[0]);
        cardWidth = Integer.parseInt(input[1]);
    }

    private double getPrefSize(int cellSize) {
        return (double) cellSize * numberOfCards/2;
    }

    private void fixNumberOfCards() {
        if (numberOfCards % 2 != 0) {
            numberOfCards++;
        }
    }

    private void makeTotalCards(Color color) {
        for (int i = 0; i < numberOfCards/2; i++) {
            Color tempColor = getColor();
            Card card1 = new Card(cardHeight, cardWidth, color, tempColor);
            Card card2 = new Card(cardHeight, cardWidth, color, tempColor);
            allCards.add(card1);
            allCards.add(card2);
        }
    }

    private void addCardToGrid(int x, int y) {
        int randomIndex = random.nextInt(0, allCards.size());
        Card card = allCards.get(randomIndex);
        allCards.remove(randomIndex);
        mainGrid.getChildren().add(card.getCard(x,y));
    }

    private void setGrid() {
        mainGrid.setPrefSize(getPrefSize(cardWidth), getPrefSize(cardHeight));
        int x = 0;
        int y = 0;
        while (!allCards.isEmpty()) {
            addCardToGrid(x,y);
            x = (x < Math.sqrt(numberOfCards)) ? x + 1 : 0;
            y += (x == 0) ? 1 : 0;
        }
    }

    public int getNumberOfCards() {
        return this.numberOfCards;
    }

    public Pane init(Color color) {
        fixNumberOfCards();
        makeTotalCards(color);
        setGrid();
        return mainGrid;
    }
}
