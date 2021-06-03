package rent.menu;

import rent.model.IntegerWrapper;

public class TestCase {
    public static void main(String[] args) {
        IntegerWrapper integerWrapper1 = new IntegerWrapper(1);
        IntegerWrapper integerWrapper2 = new IntegerWrapper(1);

        if (integerWrapper1.equals(integerWrapper2)) {
            System.out.println("Wrappers are equal");
        }
    }
}
