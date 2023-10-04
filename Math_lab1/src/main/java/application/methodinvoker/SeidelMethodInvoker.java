package application.methodinvoker;

import application.applicationManager.SeidelMethodManager;
import application.matrix.Matrix;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SeidelMethodInvoker implements MethodInvoker{
    private final Matrix matrix;
    private double[] curApproximation;
    private double[] prevApproximation;
    private int stepsCount = 0;
    private double[] uncertainties;
    public SeidelMethodInvoker(Matrix matrix){
        this.matrix = matrix;
    }
    @Override
    public void invoke() {
        makeDiagonal();
        if (isSolvable()){
            approximation();
            printAnswer();
        }
        else
            System.out.println("Не соблюдено условие сходимости.");
    }

    private void makeDiagonal(){
        int size = matrix.getSize();
        Set<Integer> swappedRows = new HashSet<>();
        for (int i = 0; i < size; i++){
            double maxValue = Double.MIN_VALUE;
            int index = -1;
            for (int j = 0; j < size; j++){
                if (Math.abs(matrix.getA()[i][j]) > maxValue){
                    maxValue = Math.abs(matrix.getA()[i][j]);
                    index = j;
                }
            }
            if (!swappedRows.contains(index)){
                swapRows(matrix, i, index);
                swappedRows.add(index);
                i--;
            }
        }
    }

    private void swapRows(Matrix matrix, int firstRow, int secondRow){
        double[] temp = matrix.getA()[firstRow];
        matrix.getA()[firstRow] = matrix.getA()[secondRow];
        matrix.getA()[secondRow] = temp;
        double tempB = matrix.getB()[firstRow];
        matrix.getB()[firstRow] = matrix.getB()[secondRow];
        matrix.getB()[secondRow] = tempB;
    }

    private boolean isSolvable(){
        double sum;
        for (int i = 0; i < matrix.getSize(); i++){
            sum = 0;
            for (int j = 0; j < matrix.getSize(); j++){
                sum += Math.abs(matrix.getA()[i][j]);
            }
            sum -= Math.abs(matrix.getA()[i][i]);
            if (sum > Math.abs(matrix.getA()[i][i])) return false;
        }
        return true;
    }

    private boolean isFinish(){
        for (int i = 0; i < matrix.getSize(); i++){
            if (Math.abs(curApproximation[i] - prevApproximation[i]) > matrix.getEpsilon()) return false;
        }
        return true;
    }

    private void zeroApproximation(){
        stepsCount++;
        curApproximation = new double[matrix.getSize()];
        prevApproximation = new double[matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++){
            curApproximation[i] = matrix.getB()[i]/matrix.getA()[i][i];
        }
    }

    private void approximation(){
        zeroApproximation();
        while (!isFinish()){
            stepsCount++;
            double num;
            prevApproximation = curApproximation;
            curApproximation = new double[matrix.getSize()];
            for (int i = 0; i < matrix.getSize(); i++){
                curApproximation[i] = matrix.getB()[i];
                for (int j = 0; j < matrix.getSize(); j++){
                    if (i > j) num = curApproximation[j];
                    else num = prevApproximation[j];
                    if (i != j){
                        curApproximation[i] -= matrix.getA()[i][j] * num;
                    }
                }
                curApproximation[i] /= matrix.getA()[i][i];
            }
        }
        uncertainties = new double[matrix.getSize()];
        for (int i = 0; i  < matrix.getSize(); i++){
            uncertainties[i] = Math.abs(curApproximation[i] - prevApproximation[i]);
        }
    }

    private void printAnswer(){
        //System.out.printf("%6s", stepsCount);
        System.out.println("Матрица неизвестных:");
        for (int i = 0; i < matrix.getSize(); i++) {
            System.out.printf("%17s", "x" + (i + 1) + " = " + new DecimalFormat("#.#####").format(curApproximation[i]));
        }
        System.out.println();
        System.out.println("Погрешность значений:");
        for (int i = 0; i < matrix.getSize(); i++) {
            System.out.printf("%17s", "x" + (i + 1) + " = " + new DecimalFormat("#.#####").format(uncertainties[i]));
        }
        System.out.println();
        System.out.println("Решение было найдено за " + stepsCount + " итераций.");
    }
}
