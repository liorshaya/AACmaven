package YearA.TermB.OOP1.exam.ex4;

import java.util.stream.IntStream;

class SharedResource {
    private int counter = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public void decrement() {
        synchronized (lock) {
            counter--;
        }
    }

    @Override
    public String toString() {
        return "Counter: " + this.counter;
    }
}
