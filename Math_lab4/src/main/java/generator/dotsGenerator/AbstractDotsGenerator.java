package generator.dotsGenerator;

import functions.Function;
import generator.Generator;
import lombok.Setter;
import utils.dot.Dot;

public abstract class AbstractDotsGenerator implements Generator<Dot> {
    @Setter
    private Function function;
}
