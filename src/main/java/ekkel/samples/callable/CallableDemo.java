package ekkel.samples.callable;

import ekkel.samples.tasks.TaskWithResult;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class CallableDemo {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String> fs : results) {

            try {
                // get blocks until completition
                System.out.println(fs.get());
            } catch (ExecutionException e){
                System.out.println(e);
                return;
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } finally {
                exec.shutdown();
            }
        }
    }
}
