package rent.concurrency.executionservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ExecutionServiceTest {
    public static void main(String[] args) {
        callableTest();
    }

    public static void scheduleTest() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        service.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("RUN");
        }, 0, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("NOT RUN");
        }, 0, 1, TimeUnit.SECONDS);

        service.schedule(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("HE-HE-HE");
        }, 5, TimeUnit.SECONDS);
    }

    public static void executerTest() {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<String> task = service.submit(() -> "CALL ME MAYBE");

        while (!task.isDone()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            System.out.println("Result is: " + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

    public static void firstMethod() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            Runnable worker = new MyRunnable("Task " + i);
            service.execute(worker);
        }
        service.shutdown();
    }

    public static void secondMethod() {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            Runnable worker = new MyRunnable("Task " + i);
            service.execute(worker);
        }
        service.shutdown();
    }

    public static void thirdMethod() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            Runnable worker = new MyRunnable("Task " + i);
            executor.execute(worker);
        }
        executor.shutdown();
    }

    public static void callableTest() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Future<User>> list = new ArrayList<>();
        Callable<User> callable = new MyCallable();
        for (int i = 0; i < 10; i++) {
            Future<User> future = executor.submit(callable);
            list.add(future);
        }
        for (Future<User> fut : list) {
            try {
                System.out.println("[User name]: Johny " + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
