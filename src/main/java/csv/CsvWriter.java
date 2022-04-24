package csv;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;

public class CsvWriter {

    @Setter @Getter
    private double start = 0;

    @Setter @Getter
    private double finish = 0;

    @Setter @Getter
    private double step = 0;

    @Getter @Setter
    private double delta = 1;

    @Getter
    private final File destination;


    private final DoubleBinaryOperator function;

    public CsvWriter(DoubleBinaryOperator function, File destination){
        this.function = function;
        this.destination = destination;
    }

    public void write() throws IOException{
        List<Tuple> tuples = new ArrayList<>();
        for (double i = start; i <= finish ; i+=step) {
            tuples.add(new Tuple(i, function.applyAsDouble(i,delta)));
        }
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(destination)))){
            for (Tuple tuple:
                 tuples) {
                writer.printf("%1$.3f, %2$.3f\n", tuple.x, tuple.y);
            }
        }
    }

    private class Tuple{
        private Tuple(double x, double y){
            this.x = x;
            this.y = y;
        }

        double x;
        double y;
    }
}
