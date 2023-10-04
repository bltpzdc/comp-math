package application.readers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader implements Reader{
    private Scanner scanner;

    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    @Override
    public String read(){
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
