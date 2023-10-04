package application.equations.equationSolvers;

import application.equations.Equation;
import application.equations.IrrationalEquation;

import java.text.DecimalFormat;

public class NewtonMethodSolver implements EquationSolver{
    @Override
    public double solve(Equation equation, double[] e, double eps) {
        double[] edges = e.clone();
        if (equation instanceof IrrationalEquation && (e[0] < 0 || e[1] < 0)){
            return Double.MIN_VALUE;
        }
        double x0 = edges[1];
        double x1 = x0 - equation.getEquation(x0)/equation.getDerivative(x0);
        while (!isFinish(x0, x1, eps)){
            x0 = x1;
            x1 = x0 - equation.getEquation(x0)/equation.getDerivative(x0);
        }
        return x1;
    }

    private boolean isFinish(double x0, double x1, double eps){
        return Math.abs(x0 - x1) < eps;
    }
}
