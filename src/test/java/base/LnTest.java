package base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnTest {
    @ParameterizedTest
    @CsvSource(value = {"1 ,0", "0.1, -2.303", "0.5, -0.693", "2.02, 0.703",
            "5, 1.609", "8, 2.079", "0, NaN", "-1, NaN", "100, 4.605"})
    public void testLn(double value, double expected){
        Ln ln = new Ln();
        final double delta = 0.000000001;
        assertEquals(expected, ln.ln(value, delta), 0.001);
    }
}
