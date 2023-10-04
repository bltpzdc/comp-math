package application.applicationManager;

import application.equationSystems.EquationSystem;
import application.equationSystems.systemDefiner.SystemDefiner;
import application.equationSystems.systemDefiner.SystemDefinerV1;
import application.equationSystems.systemSolver.SystemSolver;
import application.equationSystems.systemSolver.IterationsMethodSolver;
import application.readers.Reader;

public class EquationSystemManager implements ApplicationManager{
    private Reader reader;
    private SystemDefiner systemDefiner;

    public EquationSystemManager(Reader reader){
        this.reader = reader;
        systemDefiner = new SystemDefinerV1(reader);
    }
    @Override
    public void manage() {
        EquationSystem system = systemDefiner.define();
        System.out.println("Введите эпсилон:");
        double eps = 0;
        while (true){
            try {
                eps = Double.parseDouble(reader.next());
                break;
            } catch (NumberFormatException e){
                System.err.println("Введите число.");
            }
        }
        SystemSolver solver = new IterationsMethodSolver();
        solver.solve(system, 0, 0, eps);
    }
}
