package application.sectionDefiner;

import application.readers.Reader;

public class SectionDefinerV1 implements SectionDefiner{
    private Reader reader;

    public SectionDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public double[] defineSection() {
        System.out.println("Введите область интегрирования:");
        double[] coords = new double[2];
        while (true){
            coords[0] = reader.nextDouble();
            coords[1] = reader.nextDouble();
            if (coords[0] >= coords[1]){
                System.err.println("Правая граница должна быть больше левой.");
            }
            else return coords;
        }
    }
}
