import applicationManager.ApplicationManager;
import factories.Factory;
import factories.functionFactory.FunctionFactoryV1;
import functions.Function;
import generator.dotsGenerator.AbstractDotsGenerator;
import generator.dotsGenerator.OriginalDotsGenerator;
import generator.dotsGenerator.RandomDotsGeneratorV1;
import graphCreator.GraphCreator;
import graphCreator.GraphCreatorV1;
import interpolation.InterpolationMethod;
import interpolation.lagrangeMethod.LagrangeMethodV1;
import interpolation.newtonMethod.NewtonMethodV1;
import utils.printer.ConsolePrinterV1;
import utils.printer.Printer;
import utils.reader.ConsoleReaderV1;
import utils.reader.Reader;

public class Main {
    public static void main(String[] args) {
        Reader reader = new ConsoleReaderV1();
        Printer printer = new ConsolePrinterV1();
        Factory<Function> factory = new FunctionFactoryV1(reader, printer);
        AbstractDotsGenerator randomDotsGenerator = new RandomDotsGeneratorV1(reader, printer);
        InterpolationMethod method = new LagrangeMethodV1();
        OriginalDotsGenerator originalDotsGenerator = new OriginalDotsGenerator();
        GraphCreator graphCreator = new GraphCreatorV1();
        ApplicationManager manager = new ApplicationManager(factory, randomDotsGenerator, method, originalDotsGenerator, graphCreator);
        manager.manage();
    }
}
