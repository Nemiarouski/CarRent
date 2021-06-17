package rent.concurrency;

public class Number {
    private Integer num = 0;

    public void printNumber() {
        for (int i = 0; i < 2; i++) {
           num++;
        }
    }

    public Integer getNum() {
        return num;
    }
}