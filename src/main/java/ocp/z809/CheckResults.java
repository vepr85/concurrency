package ocp.z809;

/**
 * How many times will the while()loop in this code execute and output Not reached
 yet? The answer is, we don’t know! It could output zero, ten, or a million times. If our
 thread scheduler is particularly poor, it could operate infinitely! Using a while()loop to
 check for data without some kind of delay is considered a very bad coding practice as it
 ties up CPU resources for no reason.
 */
public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 500; i++) CheckResults.counter++;
        }).start();

        while (CheckResults.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }

        System.out.println("Reached!");
    }
}