package rent.concurrency;

public class Number {
    private Integer num = 0;

    public synchronized void printNumber() {
        synchronized (this) {
            num++;
        }
    }

    public Integer getNum() {
        return num;
    }
}