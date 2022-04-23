package base;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class SinTest {

    @ParameterizedTest
    @CsvSource(value = {"0 ,0", "1, 0.841", "-0.5, -0.479", "3.142, 0",
            "-2, -0.909"})
    public void testSin(double value, double expected){
        final double delta = 0.001;
        assertEquals(expected, Sin.sin(value, delta), delta);
    }
}
