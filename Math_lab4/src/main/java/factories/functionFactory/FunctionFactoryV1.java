package factories.functionFactory;

import factories.Factory;
import functions.ExponentialFunction;
import functions.Function;
import functions.QuadraticFunction;
import functions.SinusoidalFunction;
import utils.printer.Printer;
import utils.reader.Reader;

public class FunctionFactoryV1 implements Factory<Function> {
    private final Reader reader;
    private final Printer printer;

    public FunctionFactoryV1(Reader reader, Printer printer){
        this.reader = reader;
        this.printer = printer;
    }

    @Override
    public Function create() {
        printer.print("""
                Выберите функцию:
                1. y = x^2 - x + 1
                2. y = e^x
                3. y = sin(x)""");
        int choice = 0;
        while (true){
            choice = reader.nextInt();
            if (choice >= 1 && choice <= 3){
                break;
            } else {
                printer.printError("Введите число от 1 до 3.");
            }
        }
        switch (choice){
            case 1 -> {return new QuadraticFunction();}
            case 2 -> {return new ExponentialFunction();}
            case 3 -> {return new SinusoidalFunction();}
            default -> {return null;}
        }
    }
}
