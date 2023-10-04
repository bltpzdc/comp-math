package application.fillers;

import application.fileOpener.FileManager;
import application.fileOpener.FileManagerV1;
import application.matrix.Matrix;
import application.readers.FileReader;
import application.readers.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class FileFiller implements MatrixFiller {
    private Reader consoleReader;
    private File file;
    private FileManager fileManager = new FileManagerV1();
    private FileReader fileReader = new FileReader();

    public FileFiller(Reader consoleReader){
        this.consoleReader = consoleReader;
    }


    @Override
    public void fill(Matrix matrix) {
        boolean success = false;
        while (!success) {
            file = fileManager.findFile(consoleReader);
            try {
                fileReader.init(file);
            } catch (FileNotFoundException e) {
                System.err.println("Такого файла нет.");
                continue;
            }
            try {
                setSize(matrix);
                fillData(matrix);
                setEpsilon(matrix);
            } catch (NumberFormatException | NoSuchElementException e) {
                System.err.println("Неправильный формат данных в файле. Попробуйте еще раз.");
                continue;
            }
            success = true;
        }
    }

    private void setSize(Matrix matrix) throws NumberFormatException{
        int size = Integer.parseInt(fileReader.read());
        matrix.setSize(size);
    }

    private void fillData(Matrix matrix){
        matrix.setA(new double[matrix.getSize()][matrix.getSize()]);
        matrix.setB(new double[matrix.getSize()]);
        for (int i = 0; i < matrix.getSize(); i++){
            for (int j = 0; j < matrix.getSize(); j++){
                matrix.getA()[i][j] = Double.parseDouble(fileReader.read());
            }
            matrix.getB()[i] = Double.parseDouble(fileReader.read());
        }
    }

    private void setEpsilon(Matrix matrix){
        System.out.println("Введите погрешность:");
        while (true){
            try {
                double eps = Double.parseDouble(consoleReader.read());
                matrix.setEpsilon(eps);
                return;
            } catch (NumberFormatException e){
                System.err.println("Погрешность должна быть числом.");
            }
        }
    }
}
