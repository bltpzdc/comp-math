package integralMethods.oneStepMethods;

import entities.dot.Dot;
import integralMethods.IntegralMethod;
import lombok.Setter;

public abstract class AbstractOneStepIntegralMethod implements IntegralMethod<Dot> {
    @Setter
    protected double step;
}
