package application;

import application.applicationManager.ApplicationManager;
import application.applicationManager.OneEquationManager;
import application.managerDefiner.ManagerDefiner;
import application.managerDefiner.ManagerDefinerV1;
import application.readers.ConsoleReader;
import application.readers.Reader;

public class Application {
    private ApplicationManager manager;
    private ManagerDefiner definer;
    private Reader reader;
    public void run(){
        manager = definer.defineManager();
        manager.manage();
    }

    public void init(){
        reader = new ConsoleReader();
        definer = new ManagerDefinerV1(reader);
    }
}
