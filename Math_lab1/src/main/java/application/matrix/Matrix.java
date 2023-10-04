package application.matrix;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Matrix {
    private int size;
    private double[][] A;
    private double[] B;
    private double epsilon;
}
