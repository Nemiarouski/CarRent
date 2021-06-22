package rent.concurrency.executionservice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<User> {

    @Override
    public User call() throws Exception {
        Thread.sleep(1000);
        return new User(String.valueOf((int) (Math.random() * 10)));
    }
}
