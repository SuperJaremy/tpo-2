package level1;

import base.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CscTest {

    @Mock
    private Sin sin;

    @InjectMocks
    private Csc csc;

    @BeforeEach
    public void initMock(){
        Mockito.lenient().when(sin.sin(eq(0.0), anyDouble())).thenReturn(0.0);
        Mockito.lenient().when(sin.sin(eq(1.0), anyDouble())).thenReturn(0.841);
        Mockito.lenient().when(sin.sin(eq(-0.5), anyDouble())).thenReturn(-0.479);
        Mockito.lenient().when(sin.sin(eq(-2.0), anyDouble())).thenReturn(-0.909);
    }

    @ParameterizedTest
    @CsvSource(value = {"0 ,Infinity", "1, 1.188", "-0.5, -2.086",
            "-2, -1.1"})
    public void testCsc(double value, double expected){
        final double delta = 0.001;
        assertEquals(expected, csc.csc(value, delta), 0.01);
    }

    @ParameterizedTest
    @CsvSource(value = {"0 ,Infinity", "1, 1.188", "-0.5, -2.086",
            "-2, -1.1"})
    public void testCscWithoutMock(double value, double expected){
        Sin sin1 = new Sin();
        Csc csc1 = new Csc(sin1);
        final double delta = 0.001;
        assertEquals(expected, csc1.csc(value, delta), 0.01);
    }
}
