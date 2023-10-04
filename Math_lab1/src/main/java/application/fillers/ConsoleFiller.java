package application.fillers;

import application.matrix.Matrix;
import application.readers.Reader;

public class ConsoleFiller implements MatrixFiller{
    private final Reader consoleReader;
    public ConsoleFiller(Reader consoleReader){
        this.consoleReader = consoleReader;
    }

    @Override
    public void fill(Matrix matrix) {
        setMatrixSize(matrix);
        boolean success = false;
        while (!success){
            System.out.println("Введите матрицу.");
            success = fillData(matrix);
        }
        setEpsilon(matrix);
    }

    private void setMatrixSize(Matrix matrix){
        int size = 0;
        boolean success = false;
        while (!success){
            System.out.println("Введите размер матрицы (от 2 до 20):");
            try{
                size = Integer.parseInt(consoleReader.read());
                if (size > 1 && size < 21){
                    success = true;
                }
                else {
                    System.err.println("Размер должен быть от 2 до 20.");
                }
            } catch (NumberFormatException e){
                System.err.println("Размер должен быть целым числом.");
            }
        }
        matrix.setSize(size);
    }

    private boolean fillData(Matrix matrix){
        boolean success;
        matrix.setA(new double[matrix.getSize()][matrix.getSize()]);
        matrix.setB(new double[matrix.getSize()]);
        for (int i = 0; i < matrix.getSize(); i++){
            for (int j = 0; j < matrix.getSize(); j++){
                success = false;
                while (!success){
                    try{
                        matrix.getA()[i][j] = Double.parseDouble(consoleReader.read());
                        success = true;
                    } catch (NumberFormatException e){
                        System.err.println("Ошибка при вводе матрицы. Попробуйте снова.");
                        return false;
                    }
                }
            }
            success = false;
            while (!success){
                try{
                    matrix.getB()[i] = Double.parseDouble(consoleReader.read());
                    success = true;
                } catch (NumberFormatException e){
                    System.err.println("Ошибка при вводе матрицы. Попробуйте снова.");
                    return false;
                }
            }
        }
        return true;
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
