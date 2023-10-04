package application.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader implements Reader{
    private Scanner scanner;

    public void init(File file) throws FileNotFoundException {
        scanner = new Scanner(file);
    }

    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
