package functions;

import entities.dot.Dot;

public class QuadraticFunction implements Function{
    private double c;
    @Override
    public double y(double x) {
        return c*Math.exp((x*x)/4);
    }

    @Override
    public double dy(double x, double y) {
        return (x*y)/2;
    }

    @Override
    public void calculateConstants(Dot startDot) {
        c = startDot.getY() / Math.exp(startDot.getX()* startDot.getX()/4);
    }
}
