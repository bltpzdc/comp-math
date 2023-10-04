package application.equations;

import lombok.Getter;
import lombok.Setter;

public class CubicEquation implements Equation{
    @Getter
    @Setter
    private double[] constants;

    public CubicEquation(){
        constants = new double[4];
    }

    @Override
    public double getEquation(double x) {
        return constants[0]*x*x*x + constants[1]*x*x + constants[2]*x + constants[3];
    }

    @Override
    public double getDerivative(double x){
        return 3*constants[0]*x*x + 2*constants[1]*x + constants[2];
    }

    @Override
    public String toString(){
        return "c1*x^3 + c2*x^2 + c3*x + c4 = 0";
    }
}
