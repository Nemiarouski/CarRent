package rent.concurrency;

public class Program {
    public static void main(String[] args) {
        Number number = new Number();
        TestThread thread = new TestThread("1", number);
        TestThread thread1 = new TestThread("2", number);
        thread.start();
        thread1.start();
    }
}