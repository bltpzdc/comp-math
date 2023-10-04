package application.functions;

import lombok.Getter;

public class HyperbolicFunction implements IntegrableFunction{
    @Getter
    private final double breakingPoint = 0;

    @Override
    public double getValue(double x0) {
        return 1/x0;
    }

    @Override
    public boolean hasBreakingPoint(){
        return true;
    }

    @Override
    public String toString(){
        return "y = 1/x";
    }
}
