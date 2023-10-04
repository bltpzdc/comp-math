package application.fillers;

import application.matrix.Matrix;
import application.readers.Reader;

public class AutoFiller implements MatrixFiller{
    private Reader consoleReader;

    public AutoFiller(Reader consoleReader){
        this.consoleReader = consoleReader;
    }
    @Override
    public void fill(Matrix matrix) {
        setSize(matrix);
        fillData(matrix);
        setEpsilon(matrix);
    }

    private void setSize(Matrix matrix){
        int size = (int) (Math.random()*18 + 2);
        matrix.setSize(size);
    }

    private void fillData(Matrix matrix){
        matrix.setA(new double[matrix.getSize()][matrix.getSize()]);
        matrix.setB(new double[matrix.getSize()]);
        for (int i = 0; i < matrix.getSize(); i++){
            for (int j = 0; j < matrix.getSize(); j++){
                if (i == j){
                    matrix.getA()[i][j] = Math.random()*95 + 95;
                }
                else {
                    matrix.getA()[i][j] = Math.random()*10 - 5;
                }
            }
        }
        for (int i = 0; i < matrix.getSize(); i++){
            matrix.getB()[i] = Math.random()*10 - 5;
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
                System.err.println("Погрешность должна быть числом. Попробуйте еще раз.");
            }
        }
    }
}
