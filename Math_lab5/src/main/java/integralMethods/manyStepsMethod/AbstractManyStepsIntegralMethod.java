package integralMethods.manyStepsMethod;

import entities.dot.Dot;
import integralMethods.IntegralMethod;
import integralMethods.oneStepMethods.AbstractOneStepIntegralMethod;

import java.util.List;

public abstract class AbstractManyStepsIntegralMethod implements IntegralMethod<Dot[]> {
    protected AbstractOneStepIntegralMethod oneStepMethod;

    public AbstractManyStepsIntegralMethod(AbstractOneStepIntegralMethod oneStepMethod){
        this.oneStepMethod = oneStepMethod;
    }
}
