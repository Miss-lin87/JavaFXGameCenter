package se.linda.gamecenter.Games;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import se.linda.gamecenter.Componenets.Card;
import se.linda.gamecenter.FXbase.CardBase;
import se.linda.gamecenter.Functions.Delay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Memory implements BaseGame {
    private final CardBase cardBase;
    private final Pane mainGrid;
    private final Scene scene;
    private final List<Card> cardList = new ArrayList<>();

    public Memory(int cards) {
        this.cardBase = new CardBase(cards, "60x40");
        this.mainGrid = cardBase.init(Color.GREEN);
        this.scene = new Scene(mainGrid);
        gameLogic();
    }

    private void gameLogic() {
        for (Node N : mainGrid.getChildrenUnmodifiable()) {
            Card card = (Card) mainGrid.lookup("#"+N.getId());
            setCardFunction(card);
        }
    }

    private void setCardFunction(Card card) {
        card.setOnMouseClicked(_ -> {
            if (!cardList.contains(card)) {
                card.flipCard();
                cardList.add(card);
            } else {
                card.flipCard();
                cardList.remove(card);
            }
            if (cardList.size() == 2) {
                checkPair();
            }
        });
    }

    private void checkPair() {
        if (cardList.get(0).getFill().equals(cardList.get(1).getFill())) {
            disableCards(cardList);
            cardList.clear();
            checkWin();
        } else {
            new Delay(this::flipBackCards,1);
        }
    }

    private void flipBackCards() {
        cardList.get(0).flipCard();
        cardList.get(1).flipCard();
        cardList.clear();
    }

    private void disableCards(List<Card> cardList) {
        for (Card card : cardList) {
            card.setDisable(true);
        }
    }

    private void checkWin() {
        boolean allDisabled = true;
        for (Node N : mainGrid.getChildrenUnmodifiable()) {
            Card card = (Card) mainGrid.lookup("#"+N.getId());
            if (!card.isDisable()) {
                allDisabled = false;
                break;
            }
        }
        if (allDisabled) {
            System.out.println("You win!");
        }
    }

    public Scene Start() {
        return scene;
    }
}