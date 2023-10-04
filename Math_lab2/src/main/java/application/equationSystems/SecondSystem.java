package application.equationSystems;

public class SecondSystem implements EquationSystem{
    @Override
    public double getX1(double y) {
        return Math.cbrt(y/5);
    }

    @Override
    public double getY2(double x) {
        return -Math.pow(x,2) - 3;
    }

    @Override
    public String toString(){
        return """
                1) y = 5x^3,
                2) y = -x^2 - 3;""";
    }
}
