package application.functions;

import lombok.Getter;

public class SinusoidalWithDiscontinuity implements IntegrableFunction{
    @Getter
    private final double breakingPoint = 0;

    @Override
    public double getValue(double x0) {
        return Math.sin(x0)/x0;
    }

    @Override
    public boolean hasBreakingPoint() {
        return true;
    }
}
