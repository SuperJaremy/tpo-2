package level2;

import base.Ln;
import level1.Csc;
import level1.LogN;

public class Func {
    private final LogN logN;
    private final Csc csc;

    private final Ln ln;

    private final static double DELTA = 1e-12;

    public Func(Csc csc, LogN logN, Ln ln){
        this.csc =csc;
        this.logN = logN;
        this.ln = ln;
    }

    public double func(double x, double delta){
        if(x < 0 || (Math.abs(x - 0) <= DELTA)){
            return csc.csc(x, delta);
        }
        else{
            double a = (Math.pow((log10(x, delta)+log10(x, delta))+log3(x, delta),3)+log2(x, delta));
            double b = ((log10(x, delta)*log10(x, delta)/log3(x, delta)-log5(x, delta))*ln.ln(x, delta));
            return a*b;
        }
//        (((((log_10(x) + log_10(x)) + log_3(x)) ^ 3) + log_2(x)) * ((((log_10(x) * log_10(x)) / log_3(x)) - log_5(x)) * ln(x)))
    }

    private double log2(double x, double delta){
        return logN.logN(x, 2, delta);
    }

    private double log3(double x, double delta){
        return logN.logN(x, 3, delta);
    }

    private double log5(double x, double delta){
        return logN.logN(x, 5, delta);
    }

    private double log10(double x, double delta){
        return logN.logN(x, 10, delta);
    }
}
