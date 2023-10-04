package integralMethods;

import entities.dot.Dot;
import functions.Function;

public interface IntegralMethod<T> {
    T calculateIntegral(Function function, Dot startDot, double calculatedDot, double eps);
}
