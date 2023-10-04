package interpolation.newtonMethod;

import interpolation.InterpolationMethod;
import utils.dot.Dot;

import java.util.ArrayList;
import java.util.List;

public abstract class NewtonMethod implements InterpolationMethod {

    @Override
    public List<Dot> interpolate(List<Dot> startDots){
        int count = startDots.size();
        double[] coefficients = computeCoefficients(startDots);
        double start = startDots.get(0).getX();
        double end = startDots.get(startDots.size() - 1).getX();
        List<Dot> interpolatedDots = new ArrayList<>();
        for (double i = start; i <= end; i += 0.01){
            double y = coefficients[count - 1];
            for (int j = count - 2; j >= 0; j--) {
                y = y * (i - startDots.get(j).getX()) + coefficients[j];
            }
            interpolatedDots.add(new Dot(i, y));
        }
        return interpolatedDots;
    }

    abstract double[] computeCoefficients(List<Dot> startDots);
}
