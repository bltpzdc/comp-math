package interpolation;

import utils.dot.Dot;

import java.util.List;

public interface InterpolationMethod {
    List<Dot> interpolate(List<Dot> startDots);
}
