package se.linda.gamecenter.Functions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Delay {

    public Delay(Runnable method, int seconds) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(method, seconds, TimeUnit.SECONDS);
    }
}