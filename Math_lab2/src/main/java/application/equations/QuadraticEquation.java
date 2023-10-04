package application.equations;

import lombok.Getter;
import lombok.Setter;

public class QuadraticEquation implements Equation{
    @Getter
    @Setter
    private double[] constants;

    public QuadraticEquation(){
        constants = new double[3];
    }

    @Override
    public double getEquation(double x) {
        return constants[0]*x*x + constants[1]*x+ constants[2];
    }

    @Override
    public double getDerivative(double x){
        return 2*constants[0]*x + constants[1];
    }

    @Override
    public String toString(){
        return "c1*x^2 + c2*x + c3 = 0";
    }
}
