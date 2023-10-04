package application.equations.equationDefiner;

import application.equations.CubicEquation;
import application.equations.Equation;
import application.equations.IrrationalEquation;
import application.equations.QuadraticEquation;
import application.readers.Reader;

public class EquationDefinerV1 implements EquationDefiner {
    private Reader reader;

    public EquationDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public Equation defineEquation() {
        System.out.println("""
                Выберите, какое нелинейное уравнение решить:
                1) Квадратное уравнение.
                2) Кубическое уравнение.
                3) Уравнение с корнем.""");
        int choice = 1;
        while (true){
            try {
                choice = Integer.parseInt(reader.next());
                if (choice >= 1 && choice <= 3) break;
                else System.err.println("Число должно быть от 1 до 3.");
            } catch (NumberFormatException e){
                System.err.println("Введите число от 1 до 3.");
            }
        }
        switch (choice){
            case 1 -> {
                return new QuadraticEquation();
            }
            case 2 -> {
                return new CubicEquation();
            }
            case 3 -> {
                return new IrrationalEquation();
            }
            default -> {
                return null;
            }
        }
    }
}
