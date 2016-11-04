package ekkel.samples.tasks;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by abyakimenko on 05.10.2016.
 * некоторая задача, которая предполагает выполнение с учётом многопоточности
 */
public class SleepingTask extends LiftOff {

    @Override
    public void run() {

        try {

            while (countDown-- > 0) {
                System.out.println(status());
                int rndSleep = new Random().nextInt(2) + 1;
                //System.out.println("Time to sleep: " + rndSleep + " sec");
                TimeUnit.SECONDS.sleep(rndSleep);
            }
            System.out.println(this);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    @Override
    public String toString() {
        return Thread.currentThread() + "";
    }
}
