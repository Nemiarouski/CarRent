package rent.concurrency;

public class TestThread extends Thread{
    private String name;
    private Number number;

    public TestThread(String name, Number number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread: " + name + " Number:" +number.getNum());
            number.printNumber();
        }
    }
}