package functions;

import entities.dot.Dot;

public class SinusoidalFunction implements Function{
    private double c;
    @Override
    public double y(double x) {
        return Math.sin(x) + c;
    }

    @Override
    public double dy(double x, double y) {
        return Math.cos(x);
    }

    @Override
    public void calculateConstants(Dot startDot) {
        c = startDot.getY() - Math.sin(startDot.getX());
    }

    @Override
    public String toString(){
        return "y' = cos(x)";
    }
}
