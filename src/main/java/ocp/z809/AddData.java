package ocp.z809;

import java.util.concurrent.*;

public class AddData {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();

            Callable<Integer> integerCallable = () -> 30 + 11;

            System.out.println(service.submit(integerCallable).get());

            Future<Integer> result = service.submit(() -> 30 + 11);
            System.out.println(result.get());

            // sleep()throws a checked InterruptedException. Since the first lambda expression
            // has a return type, the compiler treats this as a Callableexpression that supports
            // checked exceptions.
            service.submit(() -> {Thread.sleep(1000); return null;});


            // The second lambda expression does not return a value; therefore,
            // the compiler treats this as a Runnableexpression.
            // Since Runnablemethods do not support checked exceptions, the
            // compiler will report an error trying to compile this code snippet

            // service.submit(() -> {Thread.sleep(1000);})

        } finally {
            if (service != null) service.shutdown();
        }
    }
}