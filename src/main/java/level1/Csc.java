package level1;

import base.Sin;

public class Csc {

    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public double csc(double x, double delta) {
        double a = sin.sin(x, delta);
        return 1 / a;
    }
}
