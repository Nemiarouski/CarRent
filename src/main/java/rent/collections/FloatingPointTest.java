package rent.collections;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FloatingPointTest {
    public static void main(String[] args) {
        double difference = 0.0001;

        float floatNumber = 0.1f;
        double doubleNumber = 0.1d;

        if (floatNumber - doubleNumber < difference) {
            System.out.println("They are same!");
        } else {
            System.out.println("They are different!");
        }

        double divideByZero = floatNumber/0;
        System.out.println(divideByZero);

        BigDecimal bigDecimal = new BigDecimal("2.05").setScale(1,RoundingMode.HALF_DOWN);
        BigDecimal bigDecimal1 = new BigDecimal("2.0").setScale(1,RoundingMode.HALF_DOWN);

        System.out.println(bigDecimal.compareTo(bigDecimal1) == 0);
        System.out.println(bigDecimal.equals(bigDecimal1));

        System.out.println(new BigDecimal ("5.50").setScale(2).equals(new BigDecimal("5.5").setScale(2)));

    }

    public static boolean equals(BigDecimal bigDecimal, BigDecimal bigDecimal1) {
        return bigDecimal.compareTo(bigDecimal1) == 0;
    }
}