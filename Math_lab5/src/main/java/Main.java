import applicationManager.ApplicationManager;
import entities.dot.Dot;
import factories.functionFactories.AbstractFunctionFactory;
import factories.functionFactories.FunctionFactoryV1;
import integralMethods.manyStepsMethod.AbstractManyStepsIntegralMethod;
import integralMethods.manyStepsMethod.AdamsMethod;
import integralMethods.oneStepMethods.RoungeCoutteMethod;
import utils.definers.startDataDefiner.AbstractStartDataDefiner;
import utils.definers.startDataDefiner.StartDataDefinerV1;
import utils.graphPainter.GraphPainter;
import utils.graphPainter.GraphPainterV1;
import utils.printer.Printer;
import utils.printer.PrinterV1;
import utils.reader.ConsoleReaderV1;
import utils.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader consoleReader = new ConsoleReaderV1();
        Printer printer = new PrinterV1();
        AbstractFunctionFactory functionFactory = new FunctionFactoryV1(consoleReader, printer);
        AbstractStartDataDefiner dataDefiner = new StartDataDefinerV1(consoleReader, printer);
        AbstractManyStepsIntegralMethod integralMethod = new AdamsMethod(new RoungeCoutteMethod());
        GraphPainter painter = new GraphPainterV1();
        ApplicationManager manager = new ApplicationManager(functionFactory, dataDefiner, integralMethod, painter);
        manager.manage();
    }
}
