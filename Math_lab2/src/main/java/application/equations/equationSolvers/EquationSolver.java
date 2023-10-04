package application.equations.equationSolvers;

import application.equations.Equation;

public interface EquationSolver {
    double solve(Equation equation, double[] edges, double eps);
}
