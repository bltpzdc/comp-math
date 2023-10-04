package functions;

import entities.dot.Dot;

public interface Function {
    double y(double x);
    double dy(double x, double y);
    void calculateConstants(Dot startDot);
}
