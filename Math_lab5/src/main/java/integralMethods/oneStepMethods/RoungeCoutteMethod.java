package integralMethods.oneStepMethods;

import entities.dot.Dot;
import functions.Function;

public class RoungeCoutteMethod extends AbstractOneStepIntegralMethod{
    @Override
    public Dot calculateIntegral(Function function, Dot startDot, double calculatedDot, double eps) {
        double k1 = step * function.dy(startDot.getX(), startDot.getY());
        double k2 = step * function.dy(startDot.getX() + step / 2, startDot.getY() + k1 / 2);
        double k3 = step * function.dy(startDot.getX() + step / 2, startDot.getY() + k2 / 2);
        double k4 = step * function.dy(startDot.getX() + step, startDot.getY() + k3);
        double y = startDot.getY() + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
        double x = startDot.getX() + step;
        return new Dot(x, y);
    }
}
