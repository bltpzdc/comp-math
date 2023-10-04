package application;

import application.applicationManager.ApplicationManager;
import application.applicationManager.RectangleIntegrationManager;
import application.readers.ConsoleReader;
import application.readers.Reader;

public class Application {
    private Reader consoleReader;
    private ApplicationManager manager;
    public Application(){
        this.consoleReader = new ConsoleReader();
        this.manager = new RectangleIntegrationManager(consoleReader);
    }
    public void run(){
        manager.manage();
    }
}
