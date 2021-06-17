package rent.concurrency;

public class Program {
    public static void main(String[] args) {
        Number number = new Number();
        Number number1 = new Number();
        TestThread thread = new TestThread("1", number);
        TestThread thread1 = new TestThread("2", number1);

        thread.start();
        thread1.start();
        System.out.println(number.getNum());
        System.out.println(number1.getNum());
    }
}