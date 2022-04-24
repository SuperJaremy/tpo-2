package level1;

import base.Ln;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;

@ExtendWith(MockitoExtension.class)
public class LogNTest {

    @Mock
    private Ln lnMock;

    private LogN logN;

    @BeforeEach
    public void initMock() {
        Mockito.lenient().when(lnMock.ln(anyDouble(), anyDouble())).thenAnswer(x-> Math.log(x.getArgument(0)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 0", "0.1, 2, -3.322", "0.5, 2, -1", "2, 2, 1",
            "1, 3, 0", "0.1, 3, -2.096", "0.5, 3, -0.631", "2, 5, 0.431",
            "5, 5, 1", "8, 5, 1.292", "0, 5, -Infinity", "-1, 5, NaN", "100, 5, 2.861",
            "32, 10, 1.505", "-2, 10, NaN"})
    public void testLogN(double value, double power, double expected) {
        logN = new LogN(lnMock);
        final double delta = 0.000000001;
        assertEquals(expected, logN.logN(value, power, delta), 0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2, 0", "0.1, 2, -3.322", "0.5, 2, -1", "2, 2, 1",
            "1, 3, 0", "0.1, 3, -2.096", "0.5, 3, -0.631", "2, 5, 0.431",
            "5, 5, 1", "8, 5, 1.292", "0, 5, -Infinity", "-1, 5, NaN", "100, 5, 2.861",
            "32, 10, 1.505", "-2, 10, NaN"})
    public void testLogNWithoutMock(double value, double power, double expected) {
        Ln ln = new Ln();
        logN = new LogN(ln);
        final double delta = 0.0001;
        assertEquals(expected, logN.logN(value, power, delta), 0.001);
    }
}
