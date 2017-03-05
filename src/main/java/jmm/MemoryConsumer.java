package jmm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Рассматривают три основных фундаментальных правила по пониманию настройки GC:
 Необходимо стремиться к тому, чтобы максимальное количество объектов очищалось при работе малого GC(minor grabage collection).
 Этот принцип позволяет уменьшить число и частоту работы полного сборщика мусора(full garbage collection) —
 чья работа является основной причиной больших задержек в приложении
 Чем больше памяти выделено приложению, тем лучше работает сборка мусора и тем лучше достигаются количественные
 характеристики по пропускной способности и времени отклика
 Эффективно настроить можно только 2 из 3 количественных характеристик — пропускная способность, время отклика,
 размер выделенной памяти — под эффективным значением размера необходимой памяти понимается её минимизация

 https://habrahabr.ru/post/223401/
 */
public class MemoryConsumer implements Runnable {

    private static final int OBJECT_SIZE = 1024 * 1024;
    private static final int OBJECTS_NUMBER = 8;
    private static final int ADD_PROCESS_TIME = 1000;
    private static final int NUMBER_OF_REQUEST_THREADS = 50;
    private static final long EXPERIMENT_TIME = 30000;
    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {

        start();
        Thread.sleep(EXPERIMENT_TIME);
        stop();
    }

    private static void start() {
        ExecutorService execService = Executors.newCachedThreadPool();
        for (int i = 0; i < NUMBER_OF_REQUEST_THREADS; i++) {
            execService.execute(new MemoryConsumer());
        }
    }

    private static void stop() {
        stop = true;

    }

    @Override
    public void run() {
        while (true && !stop) {
            makeObjects();
        }

    }

    private void makeObjects() {
        List<byte[]> objectList = new ArrayList<>();
        for (int i = 0; i < OBJECTS_NUMBER; i++) {
            objectList.add(new byte[OBJECT_SIZE]);
        }

        try {
            Thread.sleep(ADD_PROCESS_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}