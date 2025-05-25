package se.linda.gamecenter.Functions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Delay {
    private ScheduledExecutorService excutor;

    public Delay(Runnable method, int seconds) {
        excutor = Executors.newSingleThreadScheduledExecutor();
        excutor.schedule(method, seconds, TimeUnit.SECONDS);
    }
}