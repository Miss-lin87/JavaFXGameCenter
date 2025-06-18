package se.linda.gamecenter.Functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DelayTest {
    private int delayTime;
    private Runnable method;

    @BeforeEach
    public void init() {
        delayTime = new Random().nextInt(1, 5);
        method = Mockito.mock(Runnable.class);
    }

    @Test
    public void testCreation() {
        assertAll(
                () -> assertNotNull(new Delay(method, delayTime))
        );
    }
}