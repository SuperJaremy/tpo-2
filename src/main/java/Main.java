import base.Ln;
import base.Sin;
import csv.CsvWriter;
import level1.Csc;
import level1.LogN;
import level2.Func;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Ln ln = new Ln();
        Sin sin = new Sin();
        LogN logN = new LogN(ln);
        Csc csc = new Csc(sin);
        Func func = new Func(csc, logN, ln);
        File file = new File("./result.csv");
        CsvWriter writer = new CsvWriter(func::func, file);
        writer.setStart(-5);
        writer.setFinish(5);
        writer.setStep(0.001);
        writer.setDelta(1e-6);
        try{
            writer.write();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
