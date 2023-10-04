package application.readers;

import java.util.Scanner;

public class ConsoleReader implements Reader{
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public double nextDouble() {
        return scanner.nextDouble();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }
}
