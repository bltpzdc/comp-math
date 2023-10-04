package application.equationSystems.systemDefiner;

import application.equationSystems.EquationSystem;
import application.equationSystems.FirstSystem;
import application.equationSystems.SecondSystem;
import application.readers.Reader;

public class SystemDefinerV1 implements SystemDefiner{
    private Reader reader;

    public SystemDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public EquationSystem define() {
        System.out.println("""
                Выберите систему:
                1) y = 0.1x^3 - 7,
                   y = x^2 + 0.5;
                2) y = 5x^3,
                   y = -x^2 - 3;""");
        int choice = 0;
        while (true){
            try{
                choice = Integer.parseInt(reader.next());
                if (choice >= 1 && choice <= 2) break;
                else System.err.println("Выберите число от 1 до 2.");
            } catch (NumberFormatException e){
                System.err.println("Введите число.");
            }
        }
        switch (choice){
            case 1 -> {
                return new FirstSystem();
            }
            case 2 -> {
                return new SecondSystem();
            }
            default -> {
                return null;
            }
        }
    }
}
