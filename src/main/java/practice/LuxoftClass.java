package practice;

/**
 * Created by abyakimenko on 22.12.2016.
 */
public class LuxoftClass {

    /**
     * RaceConditions
     * Неизвестно, когда системный шедулер выделит ресурсы для дочерних потоков
     *   main READER: 0 0
         Thread-0 WRITER: 1 2
         Thread-1 READER: 1 2

         Thread-0 WRITER: 1 2
         main READER: 1 2
         Thread-1 READER: 1 2
     * @param args
     */
    public static void main(String[] args) {

        Reordering reordering = new Reordering();

        new Thread(() -> {
            reordering.writer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            reordering.reader();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        reordering.reader();
    }
}
