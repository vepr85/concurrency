package ocp.z809;

/**
 * Defining the task, or work, that a Threadinstance will execute can be done two ways in
 Java:
 ■ Provide a Runnableobject or lambda expression to the Threadconstructor.
 ■ Create a class that extends Threadand overrides the run()method.
 */
public class PrintData implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new PrintData());
        thread.start();
    }
}

/**
 *
 * for interviews, be familiar with Thread-Creation Options
 Despite the fact that the exam no longer focuses on creating threads by extending the
 Threadclass and implementing the Runnableinterface, it is extremely common when
 interviewing for a Java development position to be asked to explain the difference
 between extending the Threadclass and implementing Runnable. The following are some
 reasons to prefer one method over the other in Java:
 ■ If you need to define your own Threadrules upon which multiple tasks will rely, such
 as a priority Thread, extending Threadmay be preferable.
 ■ Since Java doesn't support multiple inheritance, extending Threaddoes not allow you to
 extend any other class, whereas implementing Runnablelets you extend another class.
 ■ Implementing Runnableis often a better object-oriented design practice since it separates the task being performed from the Threadobject performing it.
 ■ Implementing Runnableallows the class to be used by numerous ConcurrencyAPI
 classes.
 If asked this question, you should answer it accurately. You should also mention that you
 can now use the ExecutorService, which we will discuss in the next section, to perform
 thread tasks without having to create Threadobjects directly.
 */