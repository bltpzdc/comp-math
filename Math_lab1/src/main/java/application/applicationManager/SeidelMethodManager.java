package application.applicationManager;

import application.fillers.AutoFiller;
import application.fillers.ConsoleFiller;
import application.fillers.FileFiller;
import application.fillers.MatrixFiller;
import application.matrix.Matrix;
import application.methodinvoker.MethodInvoker;
import application.methodinvoker.SeidelMethodInvoker;
import application.readers.Reader;
import application.sources.Sources;
import application.sources.sourceDefiner.SourceDefiner;
import application.sources.sourceDefiner.SourceDefinerV1;

public class SeidelMethodManager implements ApplicationManager{
    private Reader consoleReader;
    private Matrix matrix;
    private Sources source;
    private final SourceDefiner sourceDefiner;
    private MatrixFiller matrixFiller;
    private final MethodInvoker seidelMethodInvoker;

    public SeidelMethodManager(Reader consoleReader, Matrix matrix){
        this.consoleReader = consoleReader;
        this.matrix = matrix;
        sourceDefiner = new SourceDefinerV1(consoleReader);
        seidelMethodInvoker = new SeidelMethodInvoker(matrix);
    }

    @Override
    public void manage() {
        source = sourceDefiner.defineSource(consoleReader);
        switch (source){
            case CONSOLE -> {
                matrixFiller = new ConsoleFiller(consoleReader);
            }
            case FILE -> {
                matrixFiller = new FileFiller(consoleReader);
            }
            case AUTO -> {
                matrixFiller = new AutoFiller(consoleReader);
            }
        }
        matrixFiller.fill(matrix);
        seidelMethodInvoker.invoke();
    }

    private void printMatrix(){
        System.out.println("Размер матрицы - " + matrix.getSize());
        System.out.println("A: ");
        for (int i = 0; i < matrix.getSize(); i++){
            for (int j = 0; j < matrix.getSize(); j++){
                System.out.print(matrix.getA()[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("B: ");
        for (int i = 0; i < matrix.getSize(); i++){
            System.out.print(matrix.getB()[i] + " ");
        }
    }

}
