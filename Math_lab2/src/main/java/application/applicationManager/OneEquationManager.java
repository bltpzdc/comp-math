package application.applicationManager;

import application.equations.Equation;
import application.equations.constantsDefiner.ConstantsDefiner;
import application.equations.constantsDefiner.ConstantsDefinerV1;
import application.equations.edgesDefiner.EdgesDefiner;
import application.equations.edgesDefiner.EdgesDefinerV1;
import application.equations.equationDefiner.EquationDefiner;
import application.equations.equationDefiner.EquationDefinerV1;
import application.equations.equationSolvers.ChordMethodSolver;
import application.equations.equationSolvers.EquationSolver;
import application.equations.equationSolvers.NewtonMethodSolver;
import application.readers.Reader;

import java.text.DecimalFormat;
import java.util.Arrays;

public class OneEquationManager implements ApplicationManager{
    private Equation equation;
    private Reader reader;
    private final EquationDefiner equationDefiner;
    private final EdgesDefiner edgesDefiner;
    private final ConstantsDefiner constantsDefiner;
    private EquationSolver firstSolver;
    private EquationSolver secondSolver;


    public OneEquationManager(Reader reader){
        this.equationDefiner = new EquationDefinerV1(reader);
        this.edgesDefiner = new EdgesDefinerV1(reader);
        this.constantsDefiner = new ConstantsDefinerV1(reader);
        this.firstSolver = new ChordMethodSolver();
        this.secondSolver = new NewtonMethodSolver();
        this.reader = reader;
    }
    @Override
    public void manage() {
        this.equation = equationDefiner.defineEquation();
        System.out.println("Вы выбрали уравнение вида: " + equation);
        equation.setConstants(constantsDefiner.defineConstants(equation.getConstants().length));
        double[] edges = edgesDefiner.defineEdges();
        System.out.println("Рассматриваемый отрезок: " + Arrays.toString(edges));

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
        double firstAnswer = firstSolver.solve(equation, edges, eps);
        double secondAnswer = secondSolver.solve(equation, edges, eps);
        if (firstAnswer == Double.MIN_VALUE || secondAnswer == Double.MIN_VALUE){
            System.err.println("B уравнении с корнем не может быть отрицательных х.");
        }
        if (firstAnswer != Double.MAX_VALUE && firstAnswer != Double.MIN_VALUE) {
            System.out.print("Метод хорд, ответ - ");
            System.out.printf("%10s", new DecimalFormat("#.##########").format(firstAnswer));
            System.out.println();
        } else if (firstAnswer == Double.MAX_VALUE){
            System.out.print("Метод хорд, ответ - ");
            System.out.println("не соблюдено условие работы метода.");
        }
        if (secondAnswer != Double.MIN_VALUE){
            System.out.print("Метод касательных, ответ - ");
            System.out.printf("%10s", new DecimalFormat("#.##########").format(secondAnswer));
            System.out.println();
        }
        if (firstAnswer != Double.MIN_VALUE && firstAnswer != Double.MAX_VALUE && secondAnswer != Double.MIN_VALUE){
            System.out.print("Разница в ответах между методами: ");
            System.out.printf("%10s", new DecimalFormat("#.##########").format(Math.abs(firstAnswer - secondAnswer)));
        }
    }
}
