package ekkel.samples;

import ekkel.samples.tasks.LiftOff;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class BasicThreads {

    public static void main(String[] args) {

        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for LiftOff");
    }
}
