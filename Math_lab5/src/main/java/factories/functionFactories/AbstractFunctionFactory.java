package factories.functionFactories;

import factories.Factory;
import functions.Function;
import utils.printer.Printer;
import utils.reader.Reader;

public abstract class AbstractFunctionFactory implements Factory<Function> {
    protected Reader reader;
    protected Printer printer;

    public AbstractFunctionFactory(Reader reader, Printer printer){
        this.reader = reader;
        this.printer = printer;
    }
}
