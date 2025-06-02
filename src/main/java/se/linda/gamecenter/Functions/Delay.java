package se.linda.gamecenter.Functions;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Delay {
    private ScheduledExecutorService excutor;

    public Delay(Runnable method, int seconds) {
        this.excutor = Executors.newSingleThreadScheduledExecutor();
        this.excutor.schedule(method, seconds, TimeUnit.SECONDS);
    }
}