package ekkel.samples;

import ekkel.samples.tasks.LiftOff;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class MoreBasicThreads {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }

        System.out.println("Waiting for LiftOff");
    }
}
