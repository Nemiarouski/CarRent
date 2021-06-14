package rent.collections;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class FloatingPointTestTest {

    @Test
    void compareBigDecimal () {
        BigDecimal bigDecimal = new BigDecimal("2.05");
        BigDecimal bigDecimal1 = new BigDecimal("2.050");
        assertTrue(FloatingPointTest.equals(bigDecimal, bigDecimal1));
    }
}