package ocp.z809.mail.ru;

/**
 * Created by abyakimenko on 11.11.2016.
 */
public class SeriesRunExample extends Thread {

    private static int currentMAX = 1;
    private int mainId;
    private final Object waitObject;

    // у каждого экземляра этого объекта свой lock объект
    public SeriesRunExample(int mainId, Object waitObject) {
        this.mainId = mainId;
        this.waitObject = waitObject;
    }

    public static void example() {

        Object waitObject = new Object();
        for (int i = currentMAX; i <= 10; ++i) {

            Thread thread = new SeriesRunExample(i, waitObject);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
//            System.out.println("Start run of thread: " + mainId);
            synchronized (waitObject) {

                // постановка потоков в очередь
                while (mainId > currentMAX) {
                    waitObject.wait();
                }

                currentMAX++;
                System.out.println("Hello from thread: " + mainId);
                waitObject.notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
