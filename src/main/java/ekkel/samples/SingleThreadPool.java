package ekkel.samples;

import ekkel.samples.tasks.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class SingleThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}
