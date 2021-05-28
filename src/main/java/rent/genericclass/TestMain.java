package rent.genericclass;

public class TestMain {
    public static void main(String[] args) {
        TestCar<Integer, String, String, Boolean> testCar = new TestCar();

        testCar.setT1(0);
        testCar.setT2("Impala");
        testCar.setT3("Black");
        testCar.setT4(false);
        System.out.println(testCar);

        AbstractClass abstractClass = new TestCar();
        abstractClass.setT1(1);
        abstractClass.setT2("Impala");
        abstractClass.setT3("Black");
        abstractClass.setT4(false);
        System.out.println(abstractClass);

        TestClient testClient = new TestClient();
        testClient.setT1(0);
        testClient.setT2("Michel Jackson");
        testClient.setT3(testCar);
        System.out.println(testClient);


    }
}
