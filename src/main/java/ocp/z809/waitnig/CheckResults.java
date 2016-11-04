package ocp.z809.waitnig;

import java.util.concurrent.*;

/**
 * polling implementation without using thread directly
 */
public class CheckResults {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (long i = 0; i < 5000_00000L; i++)
                    CheckResults.counter++;
            });
            result.get(10, TimeUnit.SECONDS);
            System.out.println("Reached!");
            System.out.println("CheckResults.counter: " + CheckResults.counter);
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }
    }
}