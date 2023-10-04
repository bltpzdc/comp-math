package functions;

public class SinusoidalFunction implements Function{
    @Override
    public double calculateY(double x) {
        return Math.sin(x);
    }

    @Override
    public String toString(){
        return "y = sin(x)";
    }
}
