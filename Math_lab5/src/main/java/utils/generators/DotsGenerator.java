package utils.generators;

import entities.dot.Dot;
import functions.Function;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DotsGenerator implements Generator<Dot>{
    private Function function;
    private double start;
    private int count;
    private double step;

    @Override
    public Dot[] generate() {
        Dot[] dots = new Dot[count];
        for (int i = 0; i < count; i++){
            dots[i] = new Dot(start, function.y(start));
            start += step;
        }
        return dots;
    }
}
