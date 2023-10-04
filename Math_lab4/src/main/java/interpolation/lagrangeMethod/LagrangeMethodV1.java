package interpolation.lagrangeMethod;

import interpolation.InterpolationMethod;
import utils.dot.Dot;

import java.util.ArrayList;
import java.util.List;

public class LagrangeMethodV1 implements InterpolationMethod {
    @Override
    public List<Dot> interpolate(List<Dot> startDots) {
        List<Dot> interpolatedDots = new ArrayList<>();
        for (double i = startDots.get(0).getX(); i <= startDots.get(startDots.size() - 1).getX(); i += 0.1){
            double y = 0;
            for (int j = 0; j < startDots.size(); j++){
                double l = 1;
                for (int k = 0; k < startDots.size(); k++){
                    if (j != k){
                        l *= (i - startDots.get(k).getX())/(startDots.get(j).getX() - startDots.get(k).getX());
                    }
                }
                y += l * startDots.get(j).getY();
            }
            interpolatedDots.add(new Dot(i, y));
        }
        return interpolatedDots;
    }
}
