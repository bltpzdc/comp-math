package functions;

import entities.dot.Dot;

public class ExponentialFunction implements Function{
    private double c;

    @Override
    public double y(double x) {
        return c*Math.exp(x) - x - 1;
    }

    @Override
    public double dy(double x, double y) {
        return x + y;
    }

    @Override
    public void calculateConstants(Dot startDot) {
        c = (startDot.getY() + startDot.getX() + 1) / Math.exp(startDot.getX());
    }

    @Override
    public String toString(){
        return "y' = x + y";
    }
}
