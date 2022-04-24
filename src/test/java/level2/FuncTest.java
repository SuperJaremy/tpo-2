package level2;

import base.Ln;
import base.Sin;
import level1.Csc;
import level1.LogN;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FuncTest {

    @Mock
    Ln lnMock;

    Ln ln = new Ln();

    @Mock
    Csc cscMock;

    Sin sin = new Sin();
    Csc csc = new Csc(sin);

    @Mock
    LogN logNMock;

    LogN logN = new LogN(ln);

    @BeforeEach
    public void initMocks() {
        Mockito.lenient().when(lnMock.ln(anyDouble(), anyDouble())).thenAnswer(x -> Math.log(x.getArgument(0)));
        Mockito.lenient().when(cscMock.csc(anyDouble(), anyDouble())).thenAnswer(x -> (1 / Math.sin(x.getArgument(0))));
        Mockito.lenient().when(logNMock.logN(anyDouble(), anyDouble(), anyDouble())).thenAnswer(
                x -> Math.log(x.getArgument(0)) / Math.log(x.getArgument(1))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1, NaN", "0.1, 158.166", "2, -0.572",
            "0.5, 0.572", "5, -27.662", "8, -96.001", "-1, -1.188", "-0.4, -2.568",
            "-4, 1.321", "-2, -1.1"})
    public void testFunc(double value, double expected) {
        Func func = new Func(cscMock, logNMock, lnMock);
        double delta = 0.0000001;
        assertEquals(expected, func.func(value, delta), 0.001);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, NaN", "0.1, 158.166", "2, -0.572",
            "0.5, 0.572", "5, -27.662", "8, -96.001", "-1, -1.188", "-0.4, -2.568",
            "-4, 1.321", "-2, -1.1"})
    public void testFuncWithoutMock(double value, double expected) {
        Func func = new Func(csc, logN, ln);
        double delta = 0.0000001;
        assertEquals(expected, func.func(value, delta), 0.001);
    }
}
