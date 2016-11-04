package ocp.z809.scheduling;

import java.util.concurrent.*;

/**
 * Created by abyakimenko on 06.10.2016.
 *
 * In practice, these methods are among the most convenient in the ConcurrencyAPI,
    as they perform relatively complex tasks with a single line of code. The delay and period
    parameters rely on the TimeUnitargument to determine the format of the value, such as
    seconds or milliseconds.
 */
public class SchedulePool {

    public static void main(String[] args) {

        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            Runnable task1 = () -> System.out.println("Hello Zoo");
            Callable<String> task2 = () -> "Monkey";
            Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
            Future<?> result2 = service.schedule(task2, 8, TimeUnit.MINUTES);

            // The fi rst task is scheduled 10 seconds in the future, whereas the second task is scheduled
            // 8 minutes in the future.
        } finally {
            if(service != null) service.shutdown();
        }
    }
}
