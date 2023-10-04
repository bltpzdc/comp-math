package functions;

public class ExponentialFunction implements Function{
    @Override
    public double calculateY(double x) {
        return Math.pow(Math.E, x);
    }

    @Override
    public String toString(){
        return "y = e^x";
    }
}
