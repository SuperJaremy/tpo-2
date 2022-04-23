package base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ln {

    private final static double DELTA = 1e-12;

    public double ln(double x, double delta) {
        if (x < 0) {
            return Double.NaN;
        }
        if(Math.abs(x - 0) < DELTA)
            return Double.NEGATIVE_INFINITY;
        BigDecimal sum = BigDecimal.ZERO;
        int n = 1;
        BigDecimal step;
        do {
            step = makeStep(x, n);
            sum = sum.add(step);
            n++;
        } while (Math.abs(step.doubleValue()) >= delta);
        return 2 * sum.doubleValue();
    }

    private BigDecimal makeStep(double x, int n) {
        final BigDecimal divisor = BigDecimal.valueOf(2L * n - 1);
        BigDecimal dividend = BigDecimal.valueOf(x - 1).divide(BigDecimal.valueOf(x + 1), 10, RoundingMode.HALF_UP);
        dividend = dividend.pow(2 * n - 1);
        return dividend.divide(divisor, 10, RoundingMode.HALF_UP);
    }
}
