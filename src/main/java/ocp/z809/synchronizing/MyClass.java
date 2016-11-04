package ocp.z809.synchronizing;


import java.util.Map;

/**
 * Created by abyakimenko on 26.10.2016.
 */
public class MyClass implements Runnable {

    private int x;

    private int y;

    public void write() {
        x = 1;
        y = 1;
//        Thread.sleep(10000);
    }

    public void print() {
        System.out.println(y);
        System.out.println(x);
    }

    @Override
    public void run() {

        Map<String, String> map = null;

        map.put("11",":");
    }


    public static void main(String[] args) {

        MyClass myClass = new MyClass();

        /*Thread t1 = new Thread(() -> {
            try {
                myClass.write();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/
        Thread t1 = new Thread(() -> myClass.write());
        Thread t2 = new Thread(() -> myClass.print());
        Thread t3 = new Thread(new MyClass());

        t1.start();
        t2.start();
        t3.start();

//        LinkedList

        System.out.println("============================");
        System.out.println("============== t2.start() ==============");
        System.out.println("============================");
    }
}
