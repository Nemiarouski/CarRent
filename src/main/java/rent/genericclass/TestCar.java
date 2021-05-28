package rent.genericclass;

public class TestCar<T1, T2, T3, T4> extends AbstractClass{

    @Override
    public String toString() {
        return " " + getT1() + " " + getT2() + " " + getT3() + " " + getT4();
    }
}