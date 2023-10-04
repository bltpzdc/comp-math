package application.solutionMethods;

import application.functions.IntegrableFunction;
import application.functions.IrrationalFunction;

public class MiddleRectanglesMethod implements SolutionMethod{
    @Override
    public double calculateIntegral(IntegrableFunction function, double[] section) {
        if (function instanceof IrrationalFunction && section[0] < 0){
            return Double.MAX_VALUE;
        }
        double step = (section[1] - section[0])/100;
        double result = 0;
        if (!function.hasBreakingPoint()) {
            for (int i = 0; i < 100; i++) {
                result += function.getValue(section[0] + step * (i + 0.5));
            }
        } else {
            double eps = Math.pow(10, -7);
            if (Math.abs(function.getValue(function.getBreakingPoint() - eps) - function.getValue(function.getBreakingPoint() + eps)) > 1) return Double.MIN_VALUE;
            for (int i = 0; i < 100; i++) {
                if (section[0] + step * (i + 0.5) == function.getBreakingPoint()){
                    double averageValue = (function.getValue(section[0] + step * (i + 0.5) + eps) + function.getValue(section[0] + step * (i + 0.5) - eps)) / 2;
                    result += averageValue;
                } else {
                    result += function.getValue(section[0] + step * (i + 0.5));
                }
            }
        }
        result *= step;
        return result;
    }
}
