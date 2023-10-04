package application.equationSystems.systemSolver;

import application.equationSystems.EquationSystem;

import java.text.DecimalFormat;

public class IterationsMethodSolver implements SystemSolver{

    @Override
    public void solve(EquationSystem system, double x, double y, double eps) {
        double curX = system.getX1(y);
        double curY = system.getY2(x);

        while (!(Math.abs(curX - x) < eps && Math.abs(curY - y) < eps)){
            x = curX;
            y = curY;
            curX = system.getX1(y);
            curY = system.getY2(x);
        }
        System.out.println("Решение системы:");
        System.out.printf("%10s", "x = " + new DecimalFormat("#.########").format(curX));
        System.out.printf("%12s", ", y = " + new DecimalFormat("#.########").format(curY));
    }
}
