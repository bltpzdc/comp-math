package application.functions;

public interface IntegrableFunction {
    double getValue(double x0);
    boolean hasBreakingPoint();
    double getBreakingPoint();
}
