package application.equations;

import lombok.Getter;
import lombok.Setter;

public class IrrationalEquation implements Equation{
    @Getter
    @Setter
    private double[] constants;

    public IrrationalEquation(){
        this.constants = new double[2];
    }

    @Override
    public double getEquation(double x) {
        return constants[0]*Math.pow(x, 0.5) + constants[1];
    }

    @Override
    public double getDerivative(double x){
        return constants[0]*Math.pow(x, -0.5);
    }

    @Override
    public String toString(){
        return "c1*sqrt(x) + c2";
    }
}
