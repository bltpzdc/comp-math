package utils.definers.startDataDefiner;

import utils.printer.Printer;
import utils.reader.Reader;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StartDataDefinerV1 extends AbstractStartDataDefiner{
    public StartDataDefinerV1(Reader reader, Printer printer){
        super(reader, printer);
    }
    
    @Override
    public double[] define() {
        double[] data = new double[4];
        printer.print("Введите начальную точку:");
        data[0] = reader.nextDouble();
        printer.print("Введите значение функции в начальной точке:");
        data[1] = reader.nextDouble();
        printer.print("Введите конечную точку:");
        data[2] = reader.nextDouble();
        printer.print("Введите точность:");
        data[3] = reader.nextDouble();
        return data;
    }
}
