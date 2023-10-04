package factories.functionFactories;

import functions.ExponentialFunction;
import functions.Function;
import functions.QuadraticFunction;
import functions.SinusoidalFunction;
import utils.printer.Printer;
import utils.reader.Reader;

public class FunctionFactoryV1 extends AbstractFunctionFactory{

    public FunctionFactoryV1(Reader reader, Printer printer){
        super(reader, printer);
    }

    @Override
    public Function create() {
        printer.print("""
                Выберите функцию:
                1) y' = cos(x),
                2) y' = x + y,
                3) y' = (x * y)/2""");
        int choice = 0;
        while (true){
            choice = reader.nextInt();
            if (choice < 1 || choice > 3){
                printer.printError("Введите число от 1 до 3.");
            }
            else break;
        }
        switch (choice){
            case 1 -> {return new SinusoidalFunction();}
            case 2 -> {return new ExponentialFunction();}
            case 3 -> {return new QuadraticFunction();}
            default -> {return null;}
        }
    }
}
