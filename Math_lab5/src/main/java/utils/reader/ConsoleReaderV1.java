package utils.reader;

import java.io.BufferedReader;
import java.util.Scanner;

public class ConsoleReaderV1 implements Reader{
    private Scanner scanner;

    public ConsoleReaderV1(){
       scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public int nextInt() {
        while (true){
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e){
                System.err.println("Введите целое число.");
            }
        }
    }

    @Override
    public double nextDouble() {
        while (true){
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e){
                System.err.println("Введите число.");
            }
        }
    }
}
