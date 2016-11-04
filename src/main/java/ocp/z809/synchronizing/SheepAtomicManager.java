package ocp.z809.synchronizing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abyakimenko on 06.10.2016.
 *
 * How do we improve the results so that each worker is able to increment and report the
 * results in order? The most common technique is to use a monitor, also called a lock, to
 * synchronize access. A monitoris a structure that supports mutual exclusion or the property
 * that at most one thread is executing a particular segment of code at a given time.
 * In Java, any Objectcan be used as a monitor, along with the synchronizedkeyword
 * <p>
 */
public class SheepAtomicManager {

    private AtomicInteger sheepCount = new AtomicInteger(0);

    private void incrementAndReport() {
        System.out.print(sheepCount.incrementAndGet() + " ");
    }

    public static void main(String[] args) {

        doJob();
//        doJob();
//        doJob();
    }

    static void doJob() {

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(30);
            SheepAtomicManager manager = new SheepAtomicManager();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
