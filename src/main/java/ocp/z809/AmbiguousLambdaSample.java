package ocp.z809;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class AmbiguousLambdaSample {
    public static void useCallable(Callable<Integer> expression) {
    }

    public static void useSupplier(Supplier<Integer> expression) {
    }

    public static void use(Supplier<Integer> expression) {
    }

    public static void use(Callable<Integer> expression) {
    }

    public static void main(String[] args) {


        /**
         * You may remember from Chapter 4 that the Callable functional interface strongly
           resembles the Supplier functional interface, in that they both take no arguments and
           return a generic type. One difference is that the method in Callable can throw a checked
           Exception. How do you tell lambda expressions for these two apart? The answer is
           sometimes you can't.
         * */
        useCallable(() -> { throw new IOException(); }); // COMPILES

//        useSupplier(() -> { throw new IOException(); }); // DOES NOT COMPILE

//        use(() -> { throw new IOException(); }); // DOES NOT COMPILE - ambiguous lambda expression

        use((Callable<Integer>)() -> {throw new IOException("");}); // COMPILES
    }
}