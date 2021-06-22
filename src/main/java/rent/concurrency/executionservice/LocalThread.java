package rent.concurrency.executionservice;

public class LocalThread {
    public static void main(String[] args) {
        Runnable myRun = new MyRun();

        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);

        t1.start();
        t2.start();
    }
}