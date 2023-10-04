package application.managerDefiner;

import application.applicationManager.ApplicationManager;
import application.applicationManager.EquationSystemManager;
import application.applicationManager.OneEquationManager;
import application.readers.Reader;

import java.util.InputMismatchException;

public class ManagerDefinerV1 implements ManagerDefiner{
    private Reader reader;

    public ManagerDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public ApplicationManager defineManager() {
        System.out.println("""
                Выберите, что нужно сделать:
                1) Решить нелинейное уравнение.
                2) Решить систему нелинейных уравнений.""");
        int choice = 1;
        while (true){
            try {
                choice = Integer.parseInt(reader.next());
                if (choice == 1 || choice == 2) break;
                else System.err.println("Число должно быть от 1 до 2.");
            } catch (NumberFormatException e){
                System.err.println("Введите число от 1 до 2.");
            }
        }
        if (choice == 1) return new OneEquationManager(reader);
        else return new EquationSystemManager(reader);
    }
}
