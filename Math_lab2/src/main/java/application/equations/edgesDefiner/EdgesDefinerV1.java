package application.equations.edgesDefiner;

import application.readers.Reader;

public class EdgesDefinerV1 implements EdgesDefiner{
    private Reader reader;

    public EdgesDefinerV1(Reader reader){
        this.reader = reader;
    }

    @Override
    public double[] defineEdges() {
        System.out.println("Введите нижнюю границу рассматриваемого отрезка:");
        double[] edges = new double[2];
        while (true){
            try {
                edges[0] = Integer.parseInt(reader.next());
                break;
            } catch (NumberFormatException e){
                System.err.println("Введите число.");
            }
        }
        System.out.println("Введите верхнюю границу рассматриваемого отрезка:");
        while (true){
            try {
                edges[1] = Integer.parseInt(reader.next());
                if (edges[1] > edges[0]) break;
                else System.err.println("Верхняя граница должна быть больше нижней.");
            } catch (NumberFormatException e){
                System.err.println("Введите число.");
            }
        }
        return edges;
    }
}
