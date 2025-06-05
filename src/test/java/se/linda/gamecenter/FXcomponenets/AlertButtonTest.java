package se.linda.gamecenter.FXcomponenets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.linda.gamecenter.FXComponenets.AlertButton;

import static org.junit.jupiter.api.Assertions.*;

public class AlertButtonTest {

    @Test
    public void testButton() {
        AlertButton temp = new AlertButton();
        assertAll(
                () -> assertNotNull(temp)
        );
    }
}
