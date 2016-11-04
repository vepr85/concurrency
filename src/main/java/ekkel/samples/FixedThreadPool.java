package ekkel.samples;

import ekkel.samples.tasks.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class FixedThreadPool {

    public static void main(String[] args) {

        // в конструктор передаём количество потоков, которым будет ограничено использование
        // т.о. высокозатратное создание потоков происходит 1 раз
        // каждое создание потока для задачи очень затратно
        ExecutorService exec = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
