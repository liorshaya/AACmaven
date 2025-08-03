package YearA.TermB.OOP1.exam.ex4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            IntStream.range(0, 10_000_000).forEach(i -> sharedResource.increment());
        });

        Thread thread2 = new Thread(() -> {
            IntStream.range(0, 10000).forEach(i -> sharedResource.decrement());
        });

        Thread thread3 = new Thread(() -> {
            IntStream.range(0, 10).forEach(i -> {
                System.out.println(i + ": " + sharedResource);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(sharedResource);
    }
}
