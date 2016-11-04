package ocp.z809;

/**
 * In general, you should extend the Threadclass only under very specific circumstances,
    such as when you are creating your own priority-based thread. In most situations, you
   should implement the Runnableinterface rather than extend the Threadclass.
 */
public class ReadInventoryThread extends Thread {
    public void run() {
        System.out.println("Printing zoo inventory");
    }

    public static void main(String[] args) {

        ReadInventoryThread readInventoryThread = new ReadInventoryThread();
        readInventoryThread.start();

        System.out.println("begin");
        (new ReadInventoryThread()).start();
        (new Thread(new PrintData())).start();
        (new ReadInventoryThread()).start();
        System.out.println("end");
    }
}