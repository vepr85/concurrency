package ocp.z809.concurrent.classes;

import java.util.Deque;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by abyakimenko on 07.10.2016.
 */
public class ConcurrentCollectionsMain {

    public static void main(String[] args) {

        System.out.println("============= Map ConcurrentHashMap ================");
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("zebra", 52);
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));


        System.out.println("============= Deque ConcurrentLinkedDeque ================");
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());


        System.out.println("============= Deque ConcurrentLinkedDeque ================");
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);// в конец
        deque.push(4); // в начало
        System.out.println(deque.peek()); // сначала
        System.out.println(deque.pop()); // сначала
    }
}
