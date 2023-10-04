package generator.dotsGenerator;

import functions.Function;
import lombok.Setter;
import utils.dot.Dot;
import utils.printer.Printer;
import utils.reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class RandomDotsGeneratorV1 extends AbstractDotsGenerator {
    private final Reader reader;
    private final Printer printer;
    @Setter
    private Function function;

    public RandomDotsGeneratorV1(Reader reader, Printer printer){
        this.reader = reader;
        this.printer = printer;
    }

    @Override
    public List<Dot> generate() {
        List<Dot> first = new ArrayList<>();
        List<Dot> second = new ArrayList<>();
        for (int x = -3; x <= 3; x++){
            first.add(new Dot(x, function.calculateY(x)));
        }
        for (int x = 0; x <= 5; x++){
            second.add(new Dot(x, function.calculateY(x)));
        }
        printer.print("""
                Добавить шум?
                1 - Да,
                2 - Нет.""");
        int choice = choiceFrom2();
        if (choice == 1){
            for (Dot i : first){
                i.setY(i.getY() + Math.random()/10);
            }
            for (Dot i : second){
                i.setY(i.getY() + Math.random()/10);
            }
        }
        printer.print("Выберите список начальных точек:\n" +
                "1) " + first + "\n" +
                "2) " + second);
        choice = choiceFrom2();
        return choice == 1 ? first : second;
    }

    private int choiceFrom2(){
        int choice = 0;
        while (true){
            choice = reader.nextInt();
            if (choice >= 1 && choice <= 2){
                break;
            } else {
                printer.printError("Выберите 1 или 2.");
            }
        }
        return choice;
    }
}
