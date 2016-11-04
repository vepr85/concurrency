package ekkel.samples.tasks;

import java.util.concurrent.Callable;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        return "result with TaskResult " + id;
    }
}
