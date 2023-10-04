package interpolation.newtonMethod;

import utils.dot.Dot;

import java.util.List;

public class NewtonMethodV1 extends NewtonMethod{
    @Override
    protected double[] computeCoefficients(List<Dot> startDots) {
        int count = startDots.size();
        double[] coefficients = new double[count];
        for (int i = 0; i < count; i++) {
            coefficients[i] = startDots.get(i).getY();
        }
        for (int j = 1; j < count; j++) {
            for (int i = count - 1; i >= j; i--) {
                coefficients[i] = (coefficients[i] - coefficients[i - 1]) / (startDots.get(i).getX() - startDots.get(i - j).getX());
            }
        }
        return coefficients;
    }
}
