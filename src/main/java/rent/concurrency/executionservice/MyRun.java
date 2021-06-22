package rent.concurrency.executionservice;

public class MyRun implements Runnable {
    int counter;
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        counter++;
        threadLocal.set(Thread.currentThread().getName());
        System.out.println("Counter: " + counter);
        System.out.println("ThreadLocalCounter: " + threadLocal.get());
    }
}