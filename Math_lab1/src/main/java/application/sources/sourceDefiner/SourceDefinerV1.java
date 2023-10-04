package application.sources.sourceDefiner;

import application.readers.Reader;
import application.sources.Sources;

import java.util.InputMismatchException;

public class SourceDefinerV1 implements SourceDefiner{
    private final Reader reader;

    public SourceDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public Sources defineSource(Reader reader) {
        int source;
        while (true) {
            System.out.println("Введите номер источника входных данных:");
            System.out.println(Sources.FILE + "\n" +
                    Sources.CONSOLE + "\n" +
                    Sources.AUTO);
            try {
                source = Integer.parseInt(reader.read());
                switch (source){
                    case 1 -> {
                        return Sources.FILE;
                    }
                    case 2 -> {
                        return Sources.CONSOLE;
                    }
                    case 3 -> {
                        return Sources.AUTO;
                    }
                    default -> System.err.println("Требуется число от 1 до 3.");
                }
            } catch (NumberFormatException e){
                System.err.println("Следует вводить только целые числа.");
            }
        }
    }
}
