package application;

import application.applicationManager.ApplicationManager;
import application.applicationManager.SeidelMethodManager;
import application.matrix.Matrix;
import application.readers.ConsoleReader;
import application.readers.Reader;

public class Application {
    private final Reader consoleReader = new ConsoleReader();
    private Matrix matrix = new Matrix();
    private ApplicationManager manager = new SeidelMethodManager(consoleReader, matrix);
    public void run(){
        manager.manage();
    }
}
