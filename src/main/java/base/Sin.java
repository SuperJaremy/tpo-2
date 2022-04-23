package base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sin {
    public static double sin(double x, double delta) {
        double sum = 0;
        int n = 0;
        double step;
        do {
            step = makeStep(x, n);
            sum += step;
            n++;
        } while (Math.abs(step) >= delta);
        return sum;
    }

    private static double makeStep(double x, int n) {
        BigDecimal divisor = factorial(2 * n + 1);
        BigDecimal dividend = BigDecimal.valueOf(x).pow(2 * n + 1);
        if (n % 2 != 0)
            dividend = dividend.negate();
        return dividend.divide(divisor, 10, RoundingMode.HALF_UP).doubleValue();

    }

    private static BigDecimal factorial(int x) {
        BigDecimal p = BigDecimal.ONE;
        for (int i = 1; i <= x; i++) {
            p = p.multiply(BigDecimal.valueOf(i));
        }
        return p;
    }
}
