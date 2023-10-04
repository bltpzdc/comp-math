package application.equations.equationSolvers;

import application.equations.Equation;
import application.equations.IrrationalEquation;
import application.readers.Reader;

import java.text.DecimalFormat;

public class ChordMethodSolver implements EquationSolver {
    private Reader reader;

    @Override
    public double solve(Equation equation, double[] e, double eps) {
        double[] edges = e.clone();
        if (equation instanceof IrrationalEquation && (e[0] < 0 || e[1] < 0)){
            return Double.MIN_VALUE;
        }
        double x = 0;
        if (equation.getEquation(edges[0]) > 0 && equation.getEquation(edges[1]) > 0 ||
                equation.getEquation(edges[0]) < 0 && equation.getEquation(edges[1]) < 0){
            return Double.MAX_VALUE;
        }
        else {
            while (!isFinish(edges, eps)){
                x = edges[0] - ((edges[1] - edges[0]) * equation.getEquation(edges[0]))/(equation.getEquation(edges[1]) - equation.getEquation(edges[0]));
                edges[0] = edges[1];
                edges[1] = x;
            }
        }
        return x;
    }

    private boolean isFinish(double[] edges, double eps){
        return Math.abs(edges[0] - edges[1]) < eps;
    }

}
