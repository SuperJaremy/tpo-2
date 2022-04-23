package level1;

import base.Ln;

public class LogN {
    private final Ln ln;
    public LogN(Ln ln){
        this.ln = ln;
    }
    public double logN(double x, double n, double delta){
        return ln.ln(x, delta/10)/ln.ln(n, delta/10);
    }
}
