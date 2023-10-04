package application.solutionMethods;

import application.functions.IntegrableFunction;

public interface SolutionMethod {
    double calculateIntegral(IntegrableFunction function, double[] section);
}
