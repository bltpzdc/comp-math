package application.equationSystems;

public class FirstSystem implements EquationSystem{
    @Override
    public double getX1(double y) {
        return Math.cbrt(10*(y+7));
    }

    @Override
    public double getY2(double x) {
        return x*x + 0.5;
    }

    @Override
    public String toString(){
        return """
                1) y = 0.1x^3 - 7,
                2) y = x^2 + 0.5""";
    }
}
