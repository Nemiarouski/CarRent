package rent.concurrency;

public class Number {
    private int num = 0;

    public void printNumber() {
        synchronized (this) {
            num++;
        }
    }

    public int getNum() {
        return num;
    }
}