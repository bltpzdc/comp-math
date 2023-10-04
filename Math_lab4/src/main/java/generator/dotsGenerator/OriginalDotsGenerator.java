package generator.dotsGenerator;

import functions.Function;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.dot.Dot;

import java.util.ArrayList;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OriginalDotsGenerator extends AbstractDotsGenerator{
    protected double start;
    protected double end;
    protected double step;
    protected Function function;

    @Override
    public List<Dot> generate() {
        List<Dot> originalDots = new ArrayList<>();
        for (double i = start; i <= end; i += step){
            originalDots.add(new Dot(i, function.calculateY(i)));
        }
        return originalDots;
    }
}
