package utils.definers.startDataDefiner;

import utils.definers.Definer;
import utils.printer.Printer;
import utils.reader.Reader;

public abstract class AbstractStartDataDefiner implements Definer<double[]> {
    protected Reader reader;
    protected Printer printer;

    public AbstractStartDataDefiner(Reader reader, Printer printer){
        this.reader = reader;
        this.printer = printer;
    }
}
