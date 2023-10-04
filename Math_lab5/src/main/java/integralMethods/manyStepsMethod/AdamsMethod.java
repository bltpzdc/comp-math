package integralMethods.manyStepsMethod;

import entities.dot.Dot;
import functions.Function;
import integralMethods.oneStepMethods.AbstractOneStepIntegralMethod;
public class AdamsMethod extends AbstractManyStepsIntegralMethod{

    public AdamsMethod(AbstractOneStepIntegralMethod oneStepMethod) {
        super(oneStepMethod);
    }

    @Override
    public Dot[] calculateIntegral(Function function, Dot startDot, double endDot, double eps) {
        double start = startDot.getX();
        double step = (endDot - start)/4;
        int n = 5;
        while (Math.pow(step, 4) > eps){
            step = (endDot - start)/++n;
        }
        oneStepMethod.setStep(step);
        Dot[] calculatedDots = new Dot[n + 1];
        calculatedDots[0] = startDot;
        for (int i = 1; i < 4; i++){
            calculatedDots[i] = oneStepMethod.calculateIntegral(function, calculatedDots[i - 1], calculatedDots[i - 1].getX(), eps);
        }
        for (int i = 4; i < n + 1; i++){
            double newY = calculatedDots[i - 1].getY() + step * (55 * function.dy(calculatedDots[i - 1].getX(), calculatedDots[i - 1].getY())
                    - 59 * function.dy(calculatedDots[i - 2].getX(), calculatedDots[i - 2].getY()) + 37 * function.dy(calculatedDots[i - 3].getX(), calculatedDots[i - 3].getY())
                    - 9 * function.dy(calculatedDots[i - 4].getX(), calculatedDots[i - 4].getY())) / 24;
            double newX = calculatedDots[i - 1].getX() + step;
            newY = calculatedDots[i - 1].getY() + step * (251 * function.dy(newX, newY) + 646 * function.dy(calculatedDots[i - 1].getX(), calculatedDots[i - 1].getY()) -
                    264 * function.dy(calculatedDots[i - 2].getX(), calculatedDots[i - 2].getY()) + 106 * function.dy(calculatedDots[i - 3].getX(), calculatedDots[i - 3].getY()) -
                    19 * function.dy(calculatedDots[i - 4].getX(), calculatedDots[i - 4].getY())) / 720;
            calculatedDots[i] = new Dot(newX, newY);
        }
        return calculatedDots;
    }
}
