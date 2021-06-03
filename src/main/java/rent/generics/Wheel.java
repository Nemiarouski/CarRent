package rent.generics;

public class Wheel extends CarbonProduct {
    private Integer count;

    public Wheel() {
    }

    public Wheel(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}