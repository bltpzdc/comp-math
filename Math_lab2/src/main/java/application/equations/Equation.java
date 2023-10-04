package application.equations;

public interface Equation {
    double getEquation(double x);
    double getDerivative(double x);
    void setConstants(double[] constants);
    double[] getConstants();
}
