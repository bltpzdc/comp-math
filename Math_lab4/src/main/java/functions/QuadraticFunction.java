package functions;

public class QuadraticFunction implements Function{
    @Override
    public double calculateY(double x) {
        return x*x - x + 1;
    }

    @Override
    public String toString(){
        return "y = x^2 - x + 1";
    }
}
