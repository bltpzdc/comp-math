package application.equations.constantsDefiner;

import application.readers.Reader;

public class ConstantsDefinerV1 implements ConstantsDefiner{
    private Reader reader;

    public ConstantsDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public double[] defineConstants(int count) {
        double[] constants = new double[count];
        while (true) {
            System.out.println("Введите константы:");
            System.out.print("Формат - ");
            for (int i = 0; i < count; i++){
                System.out.print("c" + (i + 1) + " ");
            }
            System.out.println();
            try {
                for (int i = 0; i < count; i++) {
                    constants[i] = Integer.parseInt(reader.next());
                }
                break;
            } catch (NumberFormatException e) {
                System.err.println("Неправильный формат ввода");
            }
        }
        return constants;
    }
}
