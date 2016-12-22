package ekkel.samples;

import ekkel.samples.tasks.LiftOff;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abyakimenko on 05.10.2016.
 */
public class ScheduleThreadPool {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.sched
        for (int i = 0; i < 5; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();

//        IntStream.iterate(1, i -> 1).limit(2).11

        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = new CopyOnWriteArrayList<>(l1);
        Set<Integer> s3 = new ConcurrentSkipListSet<>();
        s3.addAll(l1);
        for(Integer item: l2) l2.add(4); // x1
        for(Integer item: s3) s3.add(5); // x2
        System.out.println(l1.size()+" "+l2.size()+" "+s3.size());


        Integer i1 = Arrays.asList(1,2,3,4,5).stream().findAny().get();
        synchronized(i1) { // y1
            Integer i2 = Arrays.asList(6,7,8,9,10)
                    .parallelStream()
                    .sorted() // y2
                    .findAny().get(); // y3
            System.out.println(i1+" "+i2);
        }
    }
}
