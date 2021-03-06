package ocp.z809;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * With a single-thread executor, results are guaranteed to be executed in the order in which
 * they are added to the executor service. Notice that the endtext is output while our thread
 * executor tasks are still running. This is because the main()method is still an independent
 * thread from the ExecutorService, and it can perform tasks while the other thread is running.
 */
public class ZooInfo {
    public static void main(String[] args) {

        Map<String,String> stringMap = new TreeMap<>();

        stringMap.put("F","1");
        stringMap.put("Z","2");
        stringMap.put("R","3");
        stringMap.put("T","4");
        stringMap.put("G","6");
        stringMap.put("B","7");
        stringMap.put("U","8");
        stringMap.put("C","9");
        stringMap.put("A","5");


        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
//            service = Executors.newCachedThreadPool();


            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory before"));
            service.execute(() -> {
                        for (int i = 0; i < 3; i++)
                            System.out.println("Printing record: " + i);
                    }
            );
            service.execute(() -> System.out.println("Printing zoo inventory after"));
            System.out.println("end");

            Future<?> future = service.submit(() -> System.out.println("Hello ZOOOO!"));

            boolean isDone = future.isDone();
            Object o = future.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (service != null) service.shutdown();
        }
    }
}