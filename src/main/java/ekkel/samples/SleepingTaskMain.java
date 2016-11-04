package ekkel.samples;

import ekkel.samples.tasks.SleepingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class SleepingTaskMain {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }

        exec.shutdown();// предотвращает отправку новых задач объекту Executor
    }
}
