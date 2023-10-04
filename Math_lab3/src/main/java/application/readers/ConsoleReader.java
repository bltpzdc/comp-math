package application.readers;

import java.util.Scanner;

public class ConsoleReader implements Reader{
    private Scanner scanner;

    public ConsoleReader(){
        this.scanner = new Scanner(System.in);
    }
    @Override
    public String next() {
        return scanner.next();
    }

    @Override
    public int nextInt() {
        while (true){
            try {
                return Integer.parseInt(this.next());
            } catch (NumberFormatException e){
                System.err.println("Неккоректный формат ввода.");
            }
        }
    }

    @Override
    public double nextDouble() {
        while (true){
            try {
                return Double.parseDouble(this.next());
            } catch (NumberFormatException e){
                System.err.println("Неккоректный формат ввода.");
            }
        }
    }

}
