package rent.genericclass;

public class TestClient<T1, T2, T3> extends AbstractClass {

    @Override
    public String toString() {
        return " " + getT1() + " " + getT2() + " " + getT3();
    }
}