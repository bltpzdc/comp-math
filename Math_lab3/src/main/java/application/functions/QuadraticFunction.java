package application.functions;

import lombok.Getter;

public class QuadraticFunction implements IntegrableFunction{
    @Getter
    private final double breakingPoint = 0;

    @Override
    public double getValue(double x0) {
        return -(x0*x0) + 5;
    }

    @Override
    public boolean hasBreakingPoint(){
        return false;
    }

    @Override
    public String toString(){
        return "y = -x^2 + 5";
    }
}
