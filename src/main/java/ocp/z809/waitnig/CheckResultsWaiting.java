package ocp.z809.waitnig;

import java.util.concurrent.*;

/**
 * polling implementation without using thread directly
 */
public class CheckResultsWaiting {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (long i = 0; i < 5000_00000L; i++)
                    CheckResultsWaiting.counter++;
            });
            result.get(10, TimeUnit.SECONDS);

            service.submit(() -> System.out.println("FIRST ONE"));
            service.submit(() -> System.out.println("SECOND ONE"));
            service.submit(() -> System.out.println("THIRD ONE"));
            service.submit(() -> System.out.println("FOURTH ONE"));

            System.out.println("Reached!");
            System.out.println("CheckResults.counter: " + CheckResultsWaiting.counter);

        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }

        if (service != null) {

            service.awaitTermination(1, TimeUnit.MINUTES);
            // Check whether all tasks are finished
            if (service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }
    }
}