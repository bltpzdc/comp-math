package application.equationSystems.systemSolver;

import application.equationSystems.EquationSystem;

public interface SystemSolver {
    void solve(EquationSystem system, double x, double y, double eps);
}
