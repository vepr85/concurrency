package ocp.z809.mail.ru;

/**
 * Created by abyakimenko on 11.11.2016.
 */
public class RandomRunExample extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void examle() {

        for (int i = 0; i < 10; i++) {
            Thread thread = new RandomRunExample();
            thread.start();
        }
    }
}
