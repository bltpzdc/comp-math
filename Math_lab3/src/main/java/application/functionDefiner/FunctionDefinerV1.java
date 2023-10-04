package application.functionDefiner;

import application.functions.*;
import application.readers.Reader;

public class FunctionDefinerV1 implements FunctionDefiner{
    private final Reader reader;

    public FunctionDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public IntegrableFunction defineFunction() {
        System.out.println("""
                Выберите функцию:
                1) y = x.
                2) y = -x^2 + 5.
                3) y = sqrt(x).
                4) y = sin(x)/x.
                5) y = 1/x""");
        int choice = 0;
        while (true) {
            choice = reader.nextInt();
            if (choice > 0 && choice < 6) break;
            else System.err.println("Выберите число от 1 до 5.");
        }
        switch (choice){
            case 1 -> {return new LinearFunction();}
            case 2 -> {return new QuadraticFunction();}
            case 3 -> {return new IrrationalFunction();}
            case 4 -> {return new SinusoidalWithDiscontinuity();}
            case 5 -> {return new HyperbolicFunction();}
            default -> {return null;}
        }
    }
}
